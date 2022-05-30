package com.example.practiceproject.app

import android.app.Application
import android.util.Log
import com.example.practiceproject.remote.retrofit.ACCESS_TOKEN
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import javax.inject.Inject


@HiltAndroidApp
class ProjectApplication() : Application() {

    @Inject
    lateinit var sessionManager: SessionManager

    var TAG = ProjectApplication::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        sessionManager.accessToken = ACCESS_TOKEN
        RxJavaPlugins.setErrorHandler {
            Log.d(TAG, "onCreate: ")
        }
    }
}