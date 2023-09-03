package com.adden00.hotel_screen.data.network

import com.adden00.hotel_screen.data.network.models.HotelDto
import retrofit2.http.GET


interface HotelApiClient {
    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelInfo(): HotelDto
}