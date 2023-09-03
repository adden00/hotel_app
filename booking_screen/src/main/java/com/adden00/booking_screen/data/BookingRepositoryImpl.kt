package com.adden00.booking_screen.data

import com.adden00.booking_screen.data.network.BookingApiClient
import com.adden00.booking_screen.domain.BookingRepository
import com.adden00.booking_screen.domain.models.BookingDomainModel

class BookingRepositoryImpl(private val api: BookingApiClient) : BookingRepository {
    override suspend fun loadBookingData(): BookingDomainModel {
        val result = api.getBookingDetails()
        return result.toDomain()
    }
}