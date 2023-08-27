package com.ibrahim.yassirMovies.di

import com.yassirMovies.data.IRemoteDataSource
import com.yassirMovies.remote.MoviesService
import com.yassirMovies.remote.RemoteDataSource
import com.ibrahim.yassirMovies.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.Locale
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {
    @Provides
    fun provideRemoteDataSource(
        apiService: MoviesService,
    ): IRemoteDataSource = RemoteDataSource(apiService)

    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addNetworkInterceptor(loggingInterceptor)
            addInterceptor { chain ->
                val original = chain.request()
                val newUrl = original.url.newBuilder()
                    .addQueryParameter("api_key", "d7a6a216cd37824fc6cc679c91bbafb8")
                    .addQueryParameter("language", Locale.getDefault().toLanguageTag()).build()
                chain.proceed(original.newBuilder().url(newUrl).build())
            }
        }.build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder().addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(BuildConfig.BASE_URL).client(okHttpClient).build()
    }


    @Provides
    @Singleton
    fun providePostsService(
        retrofit: Retrofit,
    ): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }


}