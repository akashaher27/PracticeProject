package com.example.practiceproject.app.rxjava

import androidx.lifecycle.MutableLiveData
import com.example.practiceproject.app.common.*
import com.example.practiceproject.view.common.UiResolution
import io.reactivex.rxjava3.subscribers.DisposableSubscriber

abstract class RxDisposableFlowableObserver<T>(private val uiResolution: UiResolution) :
    DisposableSubscriber<T>() {

    abstract fun success(t: T)
    abstract fun error(e: Throwable?)
    abstract fun complete()

    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(t: Throwable?) {
        when (t) {
            is AuthorizationFailureException -> { uiResolution.onAuthorizationFailure(t.errorMessage)}
            is ResourceNotFoundException -> {uiResolution.onResourceNotFoundError(t.errorMessage)}
            is NoContentFoundException -> {uiResolution}
            is SSLPiningException -> {}
            is InvalidUploadFormatException -> {}
            is InternalServerException -> {}
            else -> {
            }
        }
        error(t)
    }

    override fun onComplete() {
        complete()
    }

}