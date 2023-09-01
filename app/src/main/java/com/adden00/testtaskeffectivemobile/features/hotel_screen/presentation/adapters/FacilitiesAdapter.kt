package com.adden00.testtaskeffectivemobile.features.hotel_screen.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adden00.testtaskeffectivemobile.databinding.FacilityItemBinding

class FacilitiesAdapter :
    ListAdapter<String, FacilitiesAdapter.ItemHolder>(object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem
    }) {

    class ItemHolder(private val binding: FacilityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(facility: String) {
            binding.tvFacility.text = facility
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(FacilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.render(getItem(position))
    }
}