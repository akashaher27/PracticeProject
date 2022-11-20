package com.example.practiceproject.app.common

sealed class ServerException() : Exception()
data class AuthorizationFailureException(val errorCode: Int, val errorMessage: String) :
    ServerException()

class NoContentFoundException(val errorCode: Int, val errorMessage: String) : ServerException()
class InternalServerException(val errorCode: Int, val errorMessage: String) : ServerException()
class ResourceNotFoundException(val errorCode: Int, val errorMessage: String) : ServerException()
class InvalidUploadFormatException(val errorCode: Int, val errorMessage: String) : ServerException()
class SSLPiningException(val errorCode: Int, val errorMessage: String) : ServerException()
