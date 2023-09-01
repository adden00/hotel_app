package com.adden00.testtaskeffectivemobile.features.hotel_screen.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelDto(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("adress")
    val address: String,

    @SerialName("minimal_price")
    val minimalPrice: Int,

    @SerialName("price_for_it")
    val priceType: String,

    @SerialName("rating")
    val rating: Int,

    @SerialName("rating_name")
    val ratingName: String,

    @SerialName("image_urls")
    val imageUrls: List<String>,

    @SerialName("about_the_hotel")
    val hotelDetails: HotelDetails

)

@Serializable
data class HotelDetails(
    @SerialName("description")
    val description: String,

    @SerialName("peculiarities")
    val peculiarities: List<String>
)