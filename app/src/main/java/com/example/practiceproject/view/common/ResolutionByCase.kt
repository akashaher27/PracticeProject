package com.example.practiceproject.view.common

import com.example.practiceproject.app.common.*

abstract class ResolutionByCase() : Resolution {
    override fun onHttpException(httpException: ServerException) {
        when (httpException) {
            is NoContentFoundException -> {noContentFoundException(httpException.errorMessage)}
            is AuthorizationFailureException -> onAuthorizationFailure(httpException.errorMessage)
            is InternalServerException -> onInternalServerError(httpException.errorMessage)
            is ResourceNotFoundException -> onResourceNotFoundError(httpException.errorMessage)
            is InvalidUploadFormatException -> onInvalidUploadFormatError(httpException.errorMessage)
            is SSLPiningException -> SSLCertificateExpireError(httpException.errorMessage)
            is InternalServerException -> {}
        }
    }

    abstract fun noContentFoundException(errorMessage: String)

    abstract fun onAuthorizationFailure(errorMessage: String)

    abstract fun onInternalServerError(errorMessage: String)

    abstract fun onResourceNotFoundError(errorMessage: String)

    abstract fun onInvalidUploadFormatError(errorMessage: String)

    abstract fun SSLCertificateExpireError(errorMessage: String)

}