package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models

import com.adden00.testtaskeffectivemobile.core.delegate_utills.DelegateItem

data class HotelDetailsDelegateItem(
    val id: Int,
    val hotelName: String,
    val departureCity: String,
    val arrivalCity: String,
    val startDate: String,
    val stopDate: String,
    val nightCount: Int,
    val roomBenefits: String,
    val nutritionProgram: String,
) : DelegateItem {
    override fun content(): Any = this
    override fun id(): Int = hashCode()
    override fun compareToOther(other: DelegateItem): Boolean =
        (other as HotelDetailsDelegateItem).content() == this.content()
}