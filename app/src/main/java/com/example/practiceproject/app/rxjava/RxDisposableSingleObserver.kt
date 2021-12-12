package com.example.practiceproject.app.rxjava

import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class RxDisposableSingleObserver<T>() : DisposableSingleObserver<T>() {

    abstract fun success(t: T)
    abstract fun error(e: Throwable)

    override fun onSuccess(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
        error(e)
    }
}