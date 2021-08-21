package com.valjapan.spajampracticeandroid.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
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

     fun getThreads(): Response<Threads>? {
        try {
            val service = this.retrofit.create(ThreadApiService::class.java).getThreads().execute()
            if (service.isSuccessful) {
                return service
            } else {
                Log.d("ThreadRepository", "GET ERROR")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
         return null
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