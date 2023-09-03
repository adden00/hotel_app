package com.adden00.rooms_screen.presentation.mvi

import com.adden00.rooms_screen.presentation.models.RoomsModel

data class RoomsState(
    val rooms: List<RoomsModel> = listOf(),
    val isLoading: Boolean = false
)