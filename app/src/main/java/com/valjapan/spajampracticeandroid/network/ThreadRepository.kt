package com.valjapan.spajampracticeandroid.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ThreadRepository(url: String) {
    private var retrofit: Retrofit

    init {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        this.retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(getClient())
            .build()
    }

    fun getThreads(): Response<Threads> {
        val service = this.retrofit.create(ThreadApiService::class.java)
        return service.getThreads().execute()
    }

    fun postThreads(thread: ThreadRequest) {
        val service = this.retrofit.create(ThreadApiService::class.java)
        service.createThread(thread).execute()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder().connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

}