package com.binaracademy.retrofitwithfragment.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binaracademy.retrofitwithfragment.model.MovieModel
import com.binaracademy.retrofitwithfragment.model.Result
import com.binaracademy.retrofitwithfragment.model.movie_detail.MovieDetail
import com.binaracademy.retrofitwithfragment.network.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondViewModel : ViewModel() {

    private val mId = MutableLiveData<Int>()
    private val detail: MutableLiveData<MovieDetail> by lazy {
        MutableLiveData<MovieDetail>().also {
            getAllMovies()
        }
    }
    private val movies: MutableLiveData<List<Result>> by lazy {
        MutableLiveData<List<Result>>().also {
            getDetailMovies(mId)
        }
    }


    fun getDetail(): LiveData<MovieDetail> {
        return detail
    }

    fun getMovies(): LiveData<List<Result>> {
        return movies
    }


    private fun getAllMovies() {
        MovieApi.retrofitService.allMovies().enqueue(object : Callback<MovieModel> {
            override fun onResponse(
                call: Call<MovieModel>,
                response: Response<MovieModel>
            ) {
                movies.value = response.body()?.results
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                Log.d("Tag", t.message.toString())
            }

        })
    }

    fun getDetailMovies(idMovies: MutableLiveData<Int>) {
        MovieApi.retrofitService.getDetail().enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                detail.value = response.body()
//                print(response.body().toString())
                Log.d("Response Detail Success", response.body().toString())
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                print("ERROR MESSAGE : " + t.message.toString())
                Log.d("Response Detail", t.message.toString())
            }

        })
    }


}