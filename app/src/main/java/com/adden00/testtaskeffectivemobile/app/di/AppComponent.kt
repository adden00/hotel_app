package com.adden00.testtaskeffectivemobile.app.di

import android.content.Context
import com.adden00.testtaskeffectivemobile.features.hotel_screen.domain.HotelRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {

    fun hotelRepository(): HotelRepository

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}