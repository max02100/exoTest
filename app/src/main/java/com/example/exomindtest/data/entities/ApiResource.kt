package com.example.exomindtest.data.entities

data class ApiResource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): ApiResource<T> {
            return ApiResource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): ApiResource<T> {
            return ApiResource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): ApiResource<T> {
            return ApiResource(Status.LOADING, data, null)
        }
    }
}