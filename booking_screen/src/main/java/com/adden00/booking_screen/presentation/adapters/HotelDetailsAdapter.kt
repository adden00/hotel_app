package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingHotelDetailsItemBinding
import com.adden00.booking_screen.presentation.models.delegate_models.HotelDetailsDelegateItem
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem


class HotelDetailsAdapter : AdapterDelegate {

    class ItemHolder(private val binding: BookingHotelDetailsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun render(item: HotelDetailsDelegateItem) {
            binding.tvCityFrom.text = item.departureCity
            binding.tvCityTo.text = item.departureCity
            binding.tvDates.text = "${item.startDate} - ${item.stopDate}"
            binding.tvNightCount.text = "${item.nightCount} ночей"
            binding.tvHotel.text = item.hotelName
            binding.tvRoom.text = item.roomBenefits
            binding.tvFood.text = item.nutritionProgram
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ItemHolder(
            BookingHotelDetailsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem) {
        (holder as ItemHolder).render(item.content() as HotelDetailsDelegateItem)
    }

    override fun isOfViewType(item: DelegateItem): Boolean =
        item is HotelDetailsDelegateItem
}