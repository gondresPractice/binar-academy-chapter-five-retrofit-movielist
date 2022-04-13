package com.binaracademy.retrofitwithfragment.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binaracademy.retrofitwithfragment.R
import com.binaracademy.retrofitwithfragment.databinding.FragmentAddPostBinding
import com.binaracademy.retrofitwithfragment.databinding.FragmentDetailBinding
import com.binaracademy.retrofitwithfragment.databinding.FragmentMainBinding
import com.binaracademy.retrofitwithfragment.databinding.FragmentPostBinding
import com.binaracademy.retrofitwithfragment.model.RegisterRequest
import com.binaracademy.retrofitwithfragment.model.RegisterResponseItem
import com.binaracademy.retrofitwithfragment.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPostFragment : Fragment() {



    lateinit var binding : FragmentAddPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btnRegister.setOnClickListener {
            val passingData = RegisterRequest(
                email = binding.etUsername.text.toString(),
                password = binding.etPassword.text.toString(),
                role = binding.etRole.text.toString()
            )

            CarsApi.instance.registerBody(passingData).enqueue(object : Callback<RegisterResponseItem>{
                override fun onResponse(
                    call: Call<RegisterResponseItem>,
                    response: Response<RegisterResponseItem>
                ) {
                    val code = response.code()
                    if(code == 200){
                        Log.d("Tag","Register Body => ${response.body()}")
                    }else{
                        Log.d("TAG","Gagal")
                    }

                }

                override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAddPostBinding.inflate(inflater,container,false)
        return binding.root
    }


}