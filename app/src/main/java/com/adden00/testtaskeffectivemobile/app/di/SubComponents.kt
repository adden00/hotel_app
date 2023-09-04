package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.booking_screen.di.BookingComponent
import com.adden00.booking_screen.di.BookingComponentProvider
import com.adden00.hotel_screen.di.HotelComponentProvider
import com.adden00.hotel_screen.di.HotelInfoComponent
import com.adden00.rooms_screen.di.RoomsComponent
import com.adden00.rooms_screen.di.RoomsComponentProvider

interface SubComponents : BookingComponentProvider, HotelComponentProvider, RoomsComponentProvider {

    override fun provideBookingComponent(): BookingComponent {
        return AppComponentProvider.appComponent().bookingComponent.create()
    }

    override fun provideHotelComponent(): HotelInfoComponent {
        return AppComponentProvider.appComponent().hotelComponent.create()
    }

    override fun provideRoomsComponent(): RoomsComponent {
        return AppComponentProvider.appComponent().roomsComponent.create()
    }

}