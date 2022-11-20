package com.example.practiceproject.remote.retrofit

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OkhttpNetClient @Inject constructor(
    private val headerInterceptor: HeaderInterceptor,
    private val errorInterceptor: ErrorInterceptor
) : OkHttpClient() {

    fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor())
            .addInterceptor(headerInterceptor)
            .addInterceptor(errorInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}