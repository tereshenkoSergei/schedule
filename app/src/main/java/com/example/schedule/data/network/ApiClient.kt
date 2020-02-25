package com.example.schedule.data.network

import com.example.schedule.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private object Holder {
        val instance = ApiClient()
    }

    companion object {
        val instance: ApiClient by lazy { Holder.instance }
    }

    val apiService: ApiService

    init {
        apiService =
            createRetrofit(
                "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/ ",
                initOkHttpClient()
            ).create(ApiService::class.java)
    }

    private fun createRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    //уровень подключения
    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(5, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(interceptor)
            }
        }.build()
    }
}