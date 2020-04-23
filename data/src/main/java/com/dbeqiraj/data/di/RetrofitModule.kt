package com.dbeqiraj.data.di

import com.dbeqiraj.data.BuildConfig
import com.dbeqiraj.data.managers.EnvironmentManager
import com.dbeqiraj.data.repository.CakesApiService
import com.dbeqiraj.data.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    @Named("ok-http")
    protected fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    this.addInterceptor(HttpLoggingInterceptor().apply {
                        this.level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }
            .connectTimeout(Constants.TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(Constants.TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Singleton
    @Provides
    protected fun provideRetrofit(
        @Named("ok-http") client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(EnvironmentManager.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    internal fun provideCakesApi(retrofit: Retrofit): CakesApiService {
        return retrofit.create(CakesApiService::class.java)
    }
}