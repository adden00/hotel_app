package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models

import com.adden00.testtaskeffectivemobile.core.delegate_utills.DelegateItem

data class BookingPriceDelegateItem(
    val id: Int,
    val tourPrice: Int,
    val fuelPrice: Int,
    val servicePrice: Int,
    val allPrice: Int = tourPrice + fuelPrice + servicePrice
) : DelegateItem {
    override fun content(): Any = this
    override fun id(): Int = hashCode()
    override fun compareToOther(other: DelegateItem): Boolean =
        (other as BookingPriceDelegateItem).content() == this.content()
}