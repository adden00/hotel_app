package com.adden00.hotel_screen.presentation.mvi

sealed class HotelEvent {
    object LoadHotelInfo : HotelEvent()
}