package com.adden00.booking_screen.data.network

import com.adden00.booking_screen.data.network.models.BookingDto
import retrofit2.http.GET

interface BookingApiClient {
    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingDetails(): BookingDto
}