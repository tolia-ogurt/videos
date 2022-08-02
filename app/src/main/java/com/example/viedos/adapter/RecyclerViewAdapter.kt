package com.example.viedos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viedos.databinding.RvItemBinding
import com.example.viedos.model.Video

class RecyclerViewAdapter(
    var videosList: List<Video>,
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var onItemClick: ((Video) -> Unit)? = null

    inner class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(videosList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(videosList[position]) {
                binding.tvTitle.text = title
            }
        }
    }

    override fun getItemCount(): Int {
        return videosList.size
    }
}