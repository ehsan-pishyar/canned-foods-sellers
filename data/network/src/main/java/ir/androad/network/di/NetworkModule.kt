package ir.androad.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androad.network.ApiService
import ir.androad.network.utils.Constants
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun loggingInterceptorProvider(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun okHttpProvider(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptorProvider())
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun converterFactoryProvider(contentType: MediaType = "application/json".toMediaType()) =
        Json.asConverterFactory(contentType)

    @Provides
    @Singleton
    fun retrofitProvider(converterFactory: Converter.Factory) =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(Constants.BASE_URL)
            .build()

    @Provides
    @Singleton
    fun apiServiceProvider(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}