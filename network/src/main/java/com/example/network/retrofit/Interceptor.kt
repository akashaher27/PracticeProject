package com.example.network.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}