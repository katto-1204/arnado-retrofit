package com.example.arnadoretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET

class ApiInterface {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"  // Example base URL


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()


    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    fun getExampleData(): Call<List<ExampleResponse>> {
        return apiService.getExampleData()
    }


    private fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    interface ApiService {
        @GET("posts")
        fun getExampleData(): Call<List<ExampleResponse>>
    }
}
