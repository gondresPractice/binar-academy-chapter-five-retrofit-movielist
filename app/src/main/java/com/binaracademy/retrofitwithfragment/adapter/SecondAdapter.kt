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
import com.binaracademy.retrofitwithfragment.fragment.home.MainFragmentDirections
import com.binaracademy.retrofitwithfragment.model.*
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
           var name = item[position].title.toString()
            var subtitle = item[position].popularity.toString()
            var overview = item[position].overview.toString()
            var date = item[position].releaseDate.toString()
            var images = item[position].backdropPath.toString()
            var rating = item[position].voteAverage.toString()


          var detail = DetailMovieModel(
               name, subtitle,overview,date,images,rating)
           it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(detail))
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}