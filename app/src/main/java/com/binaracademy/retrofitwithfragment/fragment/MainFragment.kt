package com.binaracademy.retrofitwithfragment.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.binaracademy.retrofitwithfragment.R
import com.binaracademy.retrofitwithfragment.adapter.MainAdapter
import com.binaracademy.retrofitwithfragment.databinding.FragmentDetailBinding
import com.binaracademy.retrofitwithfragment.databinding.FragmentMainBinding
import com.binaracademy.retrofitwithfragment.model.GetAllCarResponseItem
import com.binaracademy.retrofitwithfragment.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {


    lateinit var binding : FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val carList = listOf(
//            GetAllCarResponseItem(
//                    "","","",0,"","Xenia",25000,"",true,""
//        ),
//            GetAllCarResponseItem(
//                "","","",0,"","Xenia",25000,"",true,""
//            ),
//            GetAllCarResponseItem(
//                "","","",0,"","Xenia",25000,"",true,""
//            )
//        )
//        binding.rvMain
//        val adapter = MainAdapter(carList)
//        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
//        binding.rvMain.layoutManager = layoutManager
//        binding.rvMain.adapter = adapter

        CarsApi.retrofitService.allCar().enqueue(object : Callback<List<GetAllCarResponseItem>> {
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                val body= response.body()
                val code = response.code()

                if(code==200){
                    Log.d("TAG",body.toString())
                    showList(body)
                }else{
                    Log.d("Tag","Fail fetch body")
                }
            }

            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                Log.d("Tag","OnFailure")
            }


        })


    }

    fun showList(data:List<GetAllCarResponseItem>?){
        val adapter = MainAdapter(data!!)
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvMain.layoutManager = layoutManager
        binding.rvMain.adapter = adapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }


}