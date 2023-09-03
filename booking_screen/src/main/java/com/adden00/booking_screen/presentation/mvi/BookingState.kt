package com.adden00.booking_screen.presentation.mvi

import com.adden00.booking_screen.presentation.models.BookingModel


data class BookingState(
    val bookingInfo: BookingModel? = null,
    val isLoading: Boolean = false
)
