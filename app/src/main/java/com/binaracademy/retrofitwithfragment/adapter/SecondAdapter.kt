package com.binaracademy.retrofitwithfragment.adapter

import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binaracademy.retrofitwithfragment.databinding.ItemRecycleviewBinding
import com.binaracademy.retrofitwithfragment.fragment.MainFragmentDirections
import com.binaracademy.retrofitwithfragment.model.DetailModel
import com.binaracademy.retrofitwithfragment.model.GetAllCarResponseItem
import com.binaracademy.retrofitwithfragment.model.MovieModel
import com.binaracademy.retrofitwithfragment.model.Result
import com.bumptech.glide.Glide

class SecondAdapter(
    private val item:List<Result>
) : RecyclerView.Adapter<SecondAdapter.MainViewHolder>() {


    class MainViewHolder(val binding: ItemRecycleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.tvNama.text = item[position].title
        holder.binding.tvPrice.text = item[position].overview


        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w780/"+item[position].backdropPath)
            .into(holder.binding.ivImage);


        holder.itemView.setOnClickListener {
//            var name = item[position].id
//            var price = item[position].price
//            var detail = DetailModel(
//                name,price
//            )
//            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(name,price))
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}