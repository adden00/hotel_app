package com.adden00.rooms_screen.presentation.mvi

sealed class RoomsEvent {
    object LoadRooms : RoomsEvent()
}