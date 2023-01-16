package ir.androad.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androad.network.services.*
import ir.androad.network.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesUserApiService(retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)

    @Singleton
    @Provides
    fun providesSellerApiService(retrofit: Retrofit): SellerApiService =
        retrofit.create(SellerApiService::class.java)

    @Singleton
    @Provides
    fun providesResultApiService(retrofit: Retrofit): ResultApiService =
        retrofit.create(ResultApiService::class.java)

    @Singleton
    @Provides
    fun providesLocationApiService(retrofit: Retrofit): LocationApiService =
        retrofit.create(LocationApiService::class.java)

    @Singleton
    @Provides
    fun providesCustomerApiService(retrofit: Retrofit): CustomerApiService =
        retrofit.create(CustomerApiService::class.java)

    @Singleton
    @Provides
    fun providesCategoryApiService(retrofit: Retrofit): CategoryApiService =
        retrofit.create(CategoryApiService::class.java)
}