package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.testtaskeffectivemobile.features.hotel_screen.data.HotelRepositoryImpl
import com.adden00.testtaskeffectivemobile.features.hotel_screen.data.network.HotelApiClient
import com.adden00.testtaskeffectivemobile.features.hotel_screen.domain.HotelRepository
import com.adden00.testtaskeffectivemobile.features.rooms_screen.data.RoomsRepositoryImpl
import com.adden00.testtaskeffectivemobile.features.rooms_screen.data.network.RoomsApiClient
import com.adden00.testtaskeffectivemobile.features.rooms_screen.domain.RoomsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHotelRepository(api: HotelApiClient): HotelRepository =
        HotelRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideRoomsRepository(api: RoomsApiClient): RoomsRepository =
        RoomsRepositoryImpl(api)
}