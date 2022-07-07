package com.example.practiceproject.app.hilt

import android.content.Context
import com.example.practiceproject.app.SessionManager
import com.example.practiceproject.app.cache.LocalDatabase
import com.example.practiceproject.app.sharedPref.SessionStore
import com.example.practiceproject.app.remote.retrofit.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): retrofit2.Retrofit {
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
    fun provideDatabase(@ApplicationContext context: Context): LocalDatabase {
        return LocalDatabase.getInstance(context)
    }

}