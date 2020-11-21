package com.example.exomindtest.data.dataSources.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.exomindtest.data.entities.ApiResource
import kotlinx.coroutines.Dispatchers

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> T): ApiResource<T> {
        try {
            val response = call()
            response?.let {
                return ApiResource.success(it)
            }
            return error("An error occured")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): ApiResource<T> {
        return ApiResource.error("Network call has failed for a following reason: $message")
    }

}

fun <A> performGetOperation(
    databaseQuery: (() -> LiveData<A>)? = null,
    networkCall: (suspend () -> ApiResource<A>)? = null,
    saveCallResult: (suspend (A?) -> Unit)? = null,
    userDatabaseInPriority: Boolean = false
): LiveData<ApiResource<A>> =
    liveData(Dispatchers.IO) {
        emit(ApiResource.loading())
        val source = MutableLiveData<ApiResource<A>>()
        databaseQuery?.invoke()?.let {
            source.postValue(it.map { ApiResource.success(it) }.value)
            emitSource(source)
        }

        if (!userDatabaseInPriority) {
            networkCall?.let {
                val responseStatus = it.invoke()
                if (responseStatus.status == ApiResource.Status.SUCCESS) {
                    responseStatus.data?.let { source.postValue(ApiResource.success(it)) }
                    emitSource(source)
                    saveCallResult?.let { it(responseStatus.data) }
                } else {
                    emit(ApiResource.error(responseStatus.message!!))
                    emitSource(source)
                }
            }
        }
    }