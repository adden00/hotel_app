package com.adden00.rooms_screen.presentation

import com.adden00.rooms_screen.domain.models.RoomDomainModel
import com.adden00.rooms_screen.presentation.models.RoomsModel

fun RoomDomainModel.toPresentation(): RoomsModel =
    RoomsModel(id, name, price, pricePer, peculiarities, imageUrls)