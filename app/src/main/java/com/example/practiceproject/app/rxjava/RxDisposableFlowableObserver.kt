package com.example.practiceproject.app.rxjava

import io.reactivex.rxjava3.subscribers.DisposableSubscriber

abstract class RxDisposableFlowableObserver<T>() : DisposableSubscriber<T>() {

    abstract fun success(t: T)
    abstract fun error(e: Throwable?)
    abstract fun complete()

    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(t: Throwable?) {
        error(t)
    }

    override fun onComplete() {
        complete()
    }

}