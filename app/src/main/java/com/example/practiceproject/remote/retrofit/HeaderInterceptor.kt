package com.example.practiceproject.remote.retrofit


import com.example.practiceproject.app.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val sessionManager: SessionManager) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(QUERY_ACCESS_TOKEN, sessionManager.accessToken)
            .build()
        val request = original.newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}