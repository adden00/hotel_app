package com.adden00.testtaskeffectivemobile.features.hotel_screen.domain.models

data class HotelDomainModel(
    val id: Int,
    val name: String,
    val address: String,
    val minimalPrice: Int,
    val priceType: String,
    val rating: Int,
    val ratingName: String,
    val imageUrls: List<String>,
    val hotelDetailsDescription: String,
    val hotelDetailsPeculiarities: List<String>
)
