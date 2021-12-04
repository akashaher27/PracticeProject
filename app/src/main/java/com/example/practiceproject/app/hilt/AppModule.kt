package com.example.practiceproject.app.hilt

import com.example.network.retrofit.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): retrofit2.Retrofit {
        return Retrofit.getClient()
    }
}