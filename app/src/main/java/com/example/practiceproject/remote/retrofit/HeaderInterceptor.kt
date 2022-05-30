package com.example.practiceproject.remote.retrofit


import com.example.practiceproject.app.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val sessionManager: SessionManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(HEADER_ACCESS_TOKEN, sessionManager.accessToken)
            .build()
        return chain.proceed(newRequest)
    }
}