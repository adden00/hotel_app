package com.adden00.rooms_screen.domain.models

data class RoomDomainModel(
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imageUrls: List<String>
)