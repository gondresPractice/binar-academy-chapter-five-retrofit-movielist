package com.binaracademy.retrofitwithfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binaracademy.retrofitwithfragment.R
import com.binaracademy.retrofitwithfragment.databinding.FragmentDetailBinding
import com.binaracademy.retrofitwithfragment.databinding.FragmentMainBinding

class DetailFragment : Fragment() {


    private val arguments : DetailFragmentArgs by navArgs()
    lateinit var binding : FragmentDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = arguments.name
        var price = arguments.price.toString()

        binding.tvName.setText(name)
        binding.tvPrice.setText(price)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }


}