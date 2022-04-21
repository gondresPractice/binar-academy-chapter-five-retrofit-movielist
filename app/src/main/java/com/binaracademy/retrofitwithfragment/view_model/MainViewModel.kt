package com.binaracademy.retrofitwithfragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binaracademy.retrofitwithfragment.model.GetAllCarResponseItem
import com.binaracademy.retrofitwithfragment.network.CarsApi
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val cars : MutableLiveData<List<GetAllCarResponseItem>> by lazy {
        MutableLiveData<List<GetAllCarResponseItem>>().also {
            getAllCar()
        }
    }


    fun getCars(): LiveData<List<GetAllCarResponseItem>>{
        return cars
    }
    private fun getAllCar(){
        CarsApi.retrofitService.allCar().enqueue(object : retrofit2.Callback<List<GetAllCarResponseItem>>{
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
               cars.value = response.body()
            }

            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
               Log.d("Tag",t.message.toString());
            }

        })
    }
}