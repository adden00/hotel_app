package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingHotelBaseInfoItemBinding
import com.adden00.booking_screen.presentation.models.delegate_models.HotelAddressDelegateItem
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem

class HotelAddressAdapter : AdapterDelegate {

    class ItemHolder(private val binding: BookingHotelBaseInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun render(item: HotelAddressDelegateItem) {
            binding.tvName.text = item.hotelName
            binding.tvAddress.text = item.hotelAddress
            binding.tvRating.text = "${item.hotelRating} ${item.hotelRatingName}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ItemHolder(
            BookingHotelBaseInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem) {
        (holder as ItemHolder).render(item.content() as HotelAddressDelegateItem)
    }

    override fun isOfViewType(item: DelegateItem): Boolean =
        item is HotelAddressDelegateItem
}