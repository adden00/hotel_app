package com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adden00.testtaskeffectivemobile.core.common_adapters.FlexboxAdapter
import com.adden00.testtaskeffectivemobile.core.common_adapters.SliderPhotoAdapter
import com.adden00.testtaskeffectivemobile.databinding.RoomItemBinding
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.models.RoomsModel
import com.google.android.flexbox.FlexboxLayoutManager

class RoomsAdapter :
    ListAdapter<RoomsModel, RoomsAdapter.ItemHolder>(object : DiffUtil.ItemCallback<RoomsModel>() {
        override fun areItemsTheSame(oldItem: RoomsModel, newItem: RoomsModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RoomsModel, newItem: RoomsModel): Boolean =
            oldItem == newItem
    }) {

    class ItemHolder(private val binding: RoomItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val sliderAdapter by lazy {
            SliderPhotoAdapter()
        }

        private val facilitiesAdapter by lazy {
            FlexboxAdapter()
        }

        @SuppressLint("SetTextI18n")
        fun render(item: RoomsModel) {
            binding.tvName.text = item.name
            binding.tvPrice.text = "от ${item.price} ₽"
            binding.tvPriceType.text = item.pricePer
            binding.slider.adapter = sliderAdapter
            sliderAdapter.submitList(item.imageUrls)
            binding.rcFacilities.adapter = facilitiesAdapter
            binding.rcFacilities.layoutManager = FlexboxLayoutManager(binding.root.context)
            facilitiesAdapter.submitList(item.peculiarities)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(RoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.render(getItem(position))
    }
}