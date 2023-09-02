package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adden00.testtaskeffectivemobile.core.delegate_utills.AdapterDelegate
import com.adden00.testtaskeffectivemobile.core.delegate_utills.DelegateItem
import com.adden00.testtaskeffectivemobile.databinding.BookingPricesItemBinding
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.BookingPriceDelegateItem

class BookingPriceAdapter : AdapterDelegate {

    class ItemHolder(private val binding: BookingPricesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun render(item: BookingPriceDelegateItem) {
            binding.tvTourPrice.text = "${item.tourPrice} ₽"
            binding.tvFuelPrice.text = "${item.fuelPrice} ₽"
            binding.tvServicePrice.text = "${item.servicePrice} ₽"
            binding.tvFinalSum.text = "${item.allPrice} ₽"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ItemHolder(
            BookingPricesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem) {
        (holder as ItemHolder).render(item.content() as BookingPriceDelegateItem)
    }

    override fun isOfViewType(item: DelegateItem): Boolean =
        item is BookingPriceDelegateItem
}