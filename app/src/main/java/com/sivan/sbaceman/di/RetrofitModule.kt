package com.sivan.sbaceman.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.sivan.sbaceman.BuildConfig
import com.sivan.sbaceman.data.remote.SbacemanApi
import com.sivan.sbaceman.data.repository.SbaceRepoImpl
import com.sivan.sbaceman.domain.repository.SbacemanRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger {
                Timber.tag("OkHttp").d(it)
            }
        ).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.AUTH_TOKEN}")
                chain.proceed(request.build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideSbacemanApi(
        retrofit: Retrofit,
    ): SbacemanApi {
        return retrofit.create(SbacemanApi::class.java)
    }

    @Provides
    @Singleton
    fun providesSbaceRepoImpl(
        api: SbacemanApi
    ): SbacemanRepository {
        return SbaceRepoImpl(api)
    }
}
