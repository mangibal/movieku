package com.iqbalfauzi.data.dependencies

import com.iqbalfauzi.data.BuildConfig
import com.iqbalfauzi.data.remote.ApiService
import com.iqbalfauzi.data.remote.MovieRemote
import com.iqbalfauzi.data.repo.Repository
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Iqbal Fauzi on 1/6/21 12:51 PM
 * iqbal.fauzi.if99@gmail.com
 */
val networkModule = module {
    factory { MovieRemote(get()) }
    factory { Repository(get()) }
    single { provideRetrofit() }
}

private fun getInterceptor(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }

    val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        chain.proceed(request)
    }

    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(apiKeyInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()
}

private fun provideRetrofit(): ApiService = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(getInterceptor())
    .addConverterFactory(
        MoshiConverterFactory.create(
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        )
    )
    .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
    .build()
    .create(ApiService::class.java)

