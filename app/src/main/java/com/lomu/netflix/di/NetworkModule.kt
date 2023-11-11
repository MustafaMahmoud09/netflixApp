package com.lomu.netflix.di

import com.lomu.api.endPoint.MovieApi
import com.lomu.api.interceptor.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMovieApi(
        retrofit: Retrofit,
    ): MovieApi {

        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named("base_url") baseUrl: String,
        @Named("gsonConverterFactory") converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient,
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named("base_url")
    fun provideBaseUrl(): String {

        return "https://api.themoviedb.org/3/"
    }

    @Provides
    @Singleton
    @Named("gsonConverterFactory")
    fun provideGsonConverterFactory(): Converter.Factory {

        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named("authorization_interceptor") interceptor: Interceptor,
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    @Named("authorization_interceptor")
    fun provideAuthorizationInterceptor(
        @Named("token") token: String,
    ): Interceptor {

        return AuthorizationInterceptor(token)
    }

    @Provides
    @Singleton
    @Named("token")
    fun provideToken(): String {

        return "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTliZDViODhhNzE2YTYwNGU5ZDk2NmI5ZjcxYTJhNCIsInN1YiI6IjY0ZTFiYjNhNWFiODFhMDExYzJmNzcwZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SU1zZvXEAEQ5lOyhcmu00lyGpqAmqtd9bRAiC-RlDN8"
    }
}