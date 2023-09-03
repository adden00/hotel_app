package com.adden00.rooms_screen.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomResponse(
    @SerialName("rooms")
    val rooms: List<RoomDto>
)

@Serializable
data class RoomDto(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("price")
    val price: Int,

    @SerialName("price_per")
    val pricePer: String,

    @SerialName("peculiarities")
    val peculiarities: List<String>,

    @SerialName("image_urls")
    val imageUrls: List<String>,


    )