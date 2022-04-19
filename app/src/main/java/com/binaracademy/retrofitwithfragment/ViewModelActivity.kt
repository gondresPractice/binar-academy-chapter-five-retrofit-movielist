package com.binaracademy.retrofitwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.binaracademy.retrofitwithfragment.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private var counter = 0

    private lateinit var binding : ActivityViewModelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        binding.root


        binding.run {
            btnMinus.setOnClickListener {
                decrement()
                updateUi()
            }

            btnPlus.setOnClickListener {
                increment()
                updateUi()
            }
        }
    }

    private fun increment(){
        counter++
    }

    private fun decrement(){

        if (counter>0){
            counter--
        }
    }

    private fun updateUi(){
        binding.tvNumber.setText(counter.toString())
    }
}