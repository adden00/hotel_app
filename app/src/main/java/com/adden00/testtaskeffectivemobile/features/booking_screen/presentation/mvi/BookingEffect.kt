package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.mvi

sealed class BookingEffect {
    object ShowError : BookingEffect()
    object Init : BookingEffect()
}