package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.mvi

sealed class BookingEvent {
    object LoadBookingDetails : BookingEvent()
    object AddTourist : BookingEvent()
    class CollapseTourist(val touristNumber: Int) : BookingEvent()
    class ExpandTourist(val touristNumber: Int) : BookingEvent()
}