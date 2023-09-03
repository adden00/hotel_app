package com.adden00.rooms_screen.data.network

import com.adden00.rooms_screen.data.network.models.RoomResponse
import retrofit2.http.GET


interface RoomsApiClient {

    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRoomsInfo(): RoomResponse
}