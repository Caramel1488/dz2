package com.example.dz2.ui

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class GifLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<GifLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: GifLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
        layoutParams.isFullSpan = true
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): GifLoadStateViewHolder {
        return GifLoadStateViewHolder.create(parent, retry)
    }
}