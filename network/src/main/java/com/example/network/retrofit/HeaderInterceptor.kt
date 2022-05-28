package com.example.network.retrofit

import com.example.network.HEADER_ACCESS_TOKEN
import com.example.network.NetworkStore
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val networkStore: NetworkStore) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
        newRequest.addHeader(HEADER_ACCESS_TOKEN, networkStore.accessToken)
        return chain.proceed(newRequest.build())
    }

}