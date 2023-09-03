package com.adden00.core.common_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adden00.core.databinding.SlederPhotoItemBinding
import com.bumptech.glide.Glide

class SliderPhotoAdapter :
    ListAdapter<String, SliderPhotoAdapter.ItemHolder>(object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem
    }) {

    class ItemHolder(private val binding: SlederPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(url: String) {
            Glide.with(binding.root.context).load(url).centerCrop().into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(
            SlederPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.render(getItem(position))
    }
}