package com.adden00.booking_screen.presentation.models.delegate_models

import com.adden00.core.delegate_utills.DelegateItem

data class HotelAddressDelegateItem(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val hotelRating: Int,
    val hotelRatingName: String
) : DelegateItem {
    override fun content(): Any = this
    override fun id(): Int = hashCode()
    override fun compareToOther(other: DelegateItem): Boolean =
        (other as HotelAddressDelegateItem).content() == this.content()
}