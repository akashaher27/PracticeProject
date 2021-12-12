package com.example.network

sealed class Response<T>(val data: T? = null, val errorString: String? = null)
class Loading<T>() : Response<T>()
class Success<T>(data: T?) : Response<T>(data)
class Error<T>(errorString: String?) : Response<T>(errorString = errorString)
