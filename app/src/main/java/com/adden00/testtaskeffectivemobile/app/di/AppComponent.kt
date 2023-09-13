package com.adden00.testtaskeffectivemobile.app.di

import android.content.Context
import com.adden00.booking_screen.di.BookingComponent
import com.adden00.booking_screen.domain.BookingRepository
import com.adden00.hotel_screen.di.HotelInfoComponent
import com.adden00.hotel_screen.domain.HotelRepository
import com.adden00.rooms_screen.di.RoomsComponent
import com.adden00.rooms_screen.domain.RoomsRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {

    fun hotelRepository(): HotelRepository
    fun roomsRepository(): RoomsRepository
    fun bookingRepository(): BookingRepository

    val bookingComponent: BookingComponent.Factory
    val hotelComponent: HotelInfoComponent.Factory
    val roomsComponent: RoomsComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}