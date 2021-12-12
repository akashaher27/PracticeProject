package com.example.practiceproject.app

import android.app.Application
import android.util.Log
import com.example.practiceproject.MainActivity
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.lang.Exception


@HiltAndroidApp
class ProjectApplication() : Application() {

    var TAG = ProjectApplication::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler{
            Log.d(TAG, "onCreate: ")
        }
    }
}