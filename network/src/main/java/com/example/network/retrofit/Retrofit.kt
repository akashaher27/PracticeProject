package com.example.network.retrofit

import com.example.network.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor())
            .build()
    }
}