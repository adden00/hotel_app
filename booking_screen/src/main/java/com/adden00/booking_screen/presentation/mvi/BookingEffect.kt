package com.adden00.booking_screen.presentation.mvi

sealed class BookingEffect {
    object ShowError : BookingEffect()
    object Init : BookingEffect()
}