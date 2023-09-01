package com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.mvi

sealed class RoomsEffect {
    object ShowError : RoomsEffect()
    object Init : RoomsEffect()
}
