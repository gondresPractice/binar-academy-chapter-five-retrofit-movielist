package com.binaracademy.retrofitwithfragment.network

import com.binaracademy.retrofitwithfragment.model.GetAllCarResponseItem
import com.binaracademy.retrofitwithfragment.model.RegisterRequest
import com.binaracademy.retrofitwithfragment.model.RegisterResponseItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://rent-cars-api.herokuapp.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CarsApiService{

    @GET("admin/car")
    fun allCar(): Call<List<GetAllCarResponseItem>>

    @POST("admin/auth/register")
    fun registerBody(@Body registerRequest: RegisterRequest): Call<RegisterResponseItem>
}

object CarsApi{
    private val logging: HttpLoggingInterceptor
    get() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val instance: CarsApiService by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(CarsApiService::class.java)
    }
    val retrofitService:CarsApiService by lazy{retrofit.create(CarsApiService::class.java)}
}