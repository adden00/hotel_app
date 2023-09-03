package com.adden00.hotel_screen.data

import com.adden00.hotel_screen.data.network.HotelApiClient
import com.adden00.hotel_screen.domain.HotelRepository
import com.adden00.hotel_screen.domain.models.HotelDomainModel

class HotelRepositoryImpl(private val api: HotelApiClient) : HotelRepository {
    override suspend fun loadHotels(): HotelDomainModel {
        val result = api.getHotelInfo()
        return result.toDomain()
    }
}