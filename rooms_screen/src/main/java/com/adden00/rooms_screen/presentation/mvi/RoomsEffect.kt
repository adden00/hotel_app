package com.adden00.rooms_screen.presentation.mvi

sealed class RoomsEffect {
    object ShowError : RoomsEffect()
    object Init : RoomsEffect()
}
