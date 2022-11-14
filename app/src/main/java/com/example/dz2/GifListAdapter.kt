package com.example.dz2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz2.databinding.ItemListGifLayoutBinding
import com.example.dz2.networking.Gif

class GifListAdapter : PagingDataAdapter<Gif, GifListAdapter.GifHolder>(COMPARATOR) {


    override fun onBindViewHolder(holder: GifHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifHolder {
        val binding =
            ItemListGifLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifHolder(binding)
    }

    class GifHolder(
        private val binding: ItemListGifLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gif: Gif) {
            val gifPath = gif.images.original.url
            Glide.with(itemView)
                .load(gifPath)
                .into(binding.imageView)
        }

    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Gif>() {
            override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
                return oldItem.images.original.url == newItem.images.original.url
            }

            override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
                return oldItem == newItem
            }
        }
    }


}