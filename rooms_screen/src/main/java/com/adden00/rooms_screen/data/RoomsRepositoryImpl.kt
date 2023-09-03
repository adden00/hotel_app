package com.adden00.rooms_screen.data

import com.adden00.rooms_screen.data.network.RoomsApiClient
import com.adden00.rooms_screen.domain.RoomsRepository
import com.adden00.rooms_screen.domain.models.RoomDomainModel

class RoomsRepositoryImpl(private val api: RoomsApiClient) : RoomsRepository {
    override suspend fun loadRooms(): List<RoomDomainModel> {
        val result = api.getRoomsInfo()
        return result.rooms.map { it.toDomain() }
    }
}