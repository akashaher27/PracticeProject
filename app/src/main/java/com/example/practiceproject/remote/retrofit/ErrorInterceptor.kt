package com.example.practiceproject.remote.retrofit

import android.content.Context
import com.example.practiceproject.R
import com.example.practiceproject.app.common.InternalServerException
import com.example.practiceproject.app.common.InvalidUploadFormatException
import com.example.practiceproject.app.common.NoContentFoundException
import com.example.practiceproject.app.common.ResourceNotFoundException
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ErrorInterceptor @Inject constructor(@ApplicationContext val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val builder = originalRequest.newBuilder()
        val request = builder
            .method(originalRequest.method, originalRequest.body)
            .build()
        val response = chain.proceed(request)
        when (response.code) {
            204, 205 -> {
                throw NoContentFoundException(
                    response.code,
                    context.getString(R.string.message_NoContentFoundException)
                )
            }
            404 -> {
                throw ResourceNotFoundException(
                    response.code,
                    context.getString(R.string.message_ResourceNotFoundException)
                )
            }
            406 -> {
                throw InvalidUploadFormatException(
                    response.code,
                    context.getString(R.string.message_InvalidUploadFormatException)
                )
            }
            else -> {
                InternalServerException(
                    response.code,
                    context.getString(R.string.message_InternalServerException)
                )
            }
        }
        return response
    }
}