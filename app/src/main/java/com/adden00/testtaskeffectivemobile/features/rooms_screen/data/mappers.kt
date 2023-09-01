package com.adden00.testtaskeffectivemobile.features.rooms_screen.data

import com.adden00.testtaskeffectivemobile.features.rooms_screen.data.network.models.RoomDto
import com.adden00.testtaskeffectivemobile.features.rooms_screen.domain.models.RoomDomainModel

fun RoomDto.toDomain(): RoomDomainModel =
    RoomDomainModel(id, name, price, pricePer, peculiarities, imageUrls)