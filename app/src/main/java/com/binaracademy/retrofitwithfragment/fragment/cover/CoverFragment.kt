package com.binaracademy.retrofitwithfragment.fragment.cover

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.binaracademy.retrofitwithfragment.R
import com.binaracademy.retrofitwithfragment.databinding.*
import com.binaracademy.retrofitwithfragment.model.RegisterRequest
import com.binaracademy.retrofitwithfragment.model.RegisterResponseItem
import com.binaracademy.retrofitwithfragment.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoverFragment : Fragment() {



    private val sharedPref = "sharedpreferences"
    lateinit var binding : ActivityCoverBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences(sharedPref, Context.MODE_PRIVATE)
        val toHome = sharedPreferences.getBoolean("loginPref",false)
        if (toHome == true){
            var handler = Handler()
            handler.postDelayed({
                findNavController().navigate(CoverFragmentDirections.actionCoverFragmentToMainFragment())
            }, 3000)

        }else{
            var handler = Handler()
            handler.postDelayed({
                findNavController().navigate(CoverFragmentDirections.actionCoverFragmentToLoginFragment())
            }, 3000)

        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = ActivityCoverBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onPause() {
        super.onPause()

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Cover","OnDestroy")
    }

}