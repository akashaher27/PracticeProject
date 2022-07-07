package com.example.practiceproject.view.common

import androidx.lifecycle.MutableLiveData
import com.example.practiceproject.app.common.ErrorResolution
import com.example.practiceproject.app.common.ResolutionType
import javax.inject.Inject

class UiResolution @Inject constructor(private val errorResolution: MutableLiveData<ErrorResolution>) :
    ResolutionByCase() {

    override fun noContentFoundException(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

    override fun onAuthorizationFailure(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

    override fun onInternalServerError(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

    override fun onResourceNotFoundError(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

    override fun onInvalidUploadFormatError(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

    override fun SSLCertificateExpireError(errorMessage: String) {
        errorResolution?.value = ErrorResolution(ResolutionType.TEST, errorMessage)
    }

}