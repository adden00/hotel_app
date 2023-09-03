package com.adden00.testtaskeffectivemobile.app.di

import android.content.Context
import com.adden00.hotel_screen.domain.HotelRepository
import com.adden00.rooms_screen.domain.RoomsRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {

    fun hotelRepository(): HotelRepository
    fun roomsRepository(): RoomsRepository
    fun bookingRepository(): com.adden00.booking_screen.domain.BookingRepository

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}