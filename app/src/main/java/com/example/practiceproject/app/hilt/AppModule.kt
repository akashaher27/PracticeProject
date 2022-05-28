package com.example.practiceproject.app.hilt

import android.content.Context
import com.example.network.retrofit.Retrofit
import com.example.practiceproject.app.SessionManager
import com.example.practiceproject.app.sharedPref.SessionStore
import com.example.practiceproject.app.sharedPref.UserStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): retrofit2.Retrofit {
        return Retrofit.getClient(context)
    }

    @Provides
    @Singleton
    fun provideSessionManager(sessionStore: SessionStore): SessionManager {
        return SessionManager(sessionStore)
    }

}