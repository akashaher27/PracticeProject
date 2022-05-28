package com.example.network.retrofit

import android.content.Context
import com.example.network.BASE_URL
import com.example.network.CONNECT_TIMEOUT
import com.example.network.NetworkStore
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    fun getClient(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkhttpClient(context))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun createOkhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor())
            .addInterceptor(HeaderInterceptor(NetworkStore(context)))
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}