package com.example.dz2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz2.databinding.ItemListGifLayoutBinding
import com.example.dz2.model.Gif

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
            /*val requestOptions = RequestOptions()
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE)
            requestOptions.timeout(10000)
            requestOptions.skipMemoryCache(true)
            requestOptions.override(SIZE_ORIGINAL)
            requestOptions.format(DecodeFormat.PREFER_RGB_565)*/
            Glide.with(itemView)
                .load(gifPath)
                .error(android.R.drawable.ic_delete)
                .placeholder(android.R.drawable.ic_menu_gallery)
                //.apply(requestOptions)
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