package com.adden00.testtaskeffectivemobile.features.rooms_screen.domain

import com.adden00.testtaskeffectivemobile.features.rooms_screen.domain.models.RoomDomainModel

interface RoomsRepository {

    suspend fun loadRooms(): List<RoomDomainModel>
}