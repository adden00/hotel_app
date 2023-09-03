package com.adden00.booking_screen.domain

import com.adden00.booking_screen.domain.models.BookingDomainModel

interface BookingRepository {
    suspend fun loadBookingData(): BookingDomainModel
}