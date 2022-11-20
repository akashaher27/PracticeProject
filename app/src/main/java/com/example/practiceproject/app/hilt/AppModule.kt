package com.example.practiceproject.app.hilt

import android.content.Context
import com.example.practiceproject.app.SessionManager
import com.example.practiceproject.app.sharedPref.SessionStore
import com.example.practiceproject.remote.retrofit.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient
    ): retrofit2.Retrofit {
        return Retrofit.getClient(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: HeaderInterceptor,
        errorInterceptor: ErrorInterceptor
    ): OkHttpClient {
        return OkhttpNetClient(headerInterceptor, errorInterceptor).getClient()
    }

    @Provides
    @Singleton
    fun provideSessionManager(sessionStore: SessionStore): SessionManager {
        return SessionManager(sessionStore)
    }

}