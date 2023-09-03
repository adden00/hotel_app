package com.adden00.hotel_screen.domain

import com.adden00.hotel_screen.domain.models.HotelDomainModel

interface HotelRepository {
    suspend fun loadHotels(): HotelDomainModel
}