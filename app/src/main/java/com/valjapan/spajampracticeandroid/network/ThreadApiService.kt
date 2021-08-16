package com.valjapan.spajampracticeandroid.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ThreadApiService {
    @GET("list")
    fun getThreads(): Call<Threads>

    @POST("create")
    fun createThread(@Body createThreadRequest: ThreadRequest): Call<SendCreateResponse>

}