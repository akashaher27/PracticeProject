package com.example.practiceproject.app.remote.retrofit

import okhttp3.logging.HttpLoggingInterceptor


fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}
