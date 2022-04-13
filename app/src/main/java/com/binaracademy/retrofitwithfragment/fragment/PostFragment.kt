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
import com.binaracademy.retrofitwithfragment.databinding.FragmentPostBinding

class PostFragment : Fragment() {


    lateinit var binding : FragmentPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentPostBinding.inflate(inflater,container,false)
        return binding.root
    }


}