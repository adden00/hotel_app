package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.testtaskeffectivemobile.features.hotel_screen.data.HotelRepositoryImpl
import com.adden00.testtaskeffectivemobile.features.hotel_screen.data.network.HotelApiClient
import com.adden00.testtaskeffectivemobile.features.hotel_screen.domain.HotelRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHotelRepository(api: HotelApiClient): HotelRepository =
        HotelRepositoryImpl(api)
}