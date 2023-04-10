package com.kerubyte.engage.common.util

sealed class Response<T> (
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Response<T>(data)
    sealed class Error<T>(message: String?) : Response<T>(null, message) {
        class NetworkError<T>(message: String?) : Error<T>(message)
        class AuthenticationError<T>(message: String?) : Error<T>(message)
        class BadRequestError<T>(message: String?) : Error<T>(message)
    }
}
