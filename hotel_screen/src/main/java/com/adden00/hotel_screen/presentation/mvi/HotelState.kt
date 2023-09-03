package com.adden00.hotel_screen.presentation.mvi

import com.adden00.hotel_screen.presentation.models.HotelModel

sealed class HotelState {
    object Init : HotelState()
    object Loading : HotelState()
    class Loaded(val hotelInfo: HotelModel) : HotelState()
    object Error : HotelState()

}