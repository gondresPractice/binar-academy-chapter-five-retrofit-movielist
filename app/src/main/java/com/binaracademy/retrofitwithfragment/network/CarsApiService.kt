package com.binaracademy.retrofitwithfragment.network

import com.binaracademy.retrofitwithfragment.model.GetAllCarResponseItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rent-cars-api.herokuapp.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CarsApiService{

    @GET("admin/car")
    fun allCar(): Call<List<GetAllCarResponseItem>>
}

object CarsApi{
    val retrofitService:CarsApiService by lazy{retrofit.create(CarsApiService::class.java)}
}