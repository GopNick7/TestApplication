package com.chisw.testapplication.data.net

import com.chisw.testapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nikita R. on 22.12.2018.
 */
object NetManager {
    private var restApi: RestAPI

    init {
        restApi = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestAPI::class.java)
    }

    fun restApi(): RestAPI {
        return restApi
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor())
            .addNetworkInterceptor { chain ->
                val request: Request
                val originalBuilder = chain.request().newBuilder()
                originalBuilder.addHeader("Content-PresentationsType", "application/json")
                request = originalBuilder.build()
                chain.proceed(request)
            }
            .build()
    }
}