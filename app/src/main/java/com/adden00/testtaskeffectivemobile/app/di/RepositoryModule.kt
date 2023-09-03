package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.hotel_screen.data.HotelRepositoryImpl
import com.adden00.hotel_screen.data.network.HotelApiClient
import com.adden00.hotel_screen.domain.HotelRepository
import com.adden00.rooms_screen.data.RoomsRepositoryImpl
import com.adden00.rooms_screen.data.network.RoomsApiClient
import com.adden00.rooms_screen.domain.RoomsRepository
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

    @Provides
    @Singleton
    fun provideBookingRepository(api: com.adden00.booking_screen.data.network.BookingApiClient): com.adden00.booking_screen.domain.BookingRepository =
        com.adden00.booking_screen.data.BookingRepositoryImpl(api)
}