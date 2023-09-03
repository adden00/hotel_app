package com.adden00.testtaskeffectivemobile.app.di.ui

import com.adden00.booking_screen.presentation.BookingFragment
import com.adden00.testtaskeffectivemobile.app.di.AppComponent
import com.adden00.testtaskeffectivemobile.app.di.ScreenScope
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [BookingModule::class])
@ScreenScope
interface BookingComponent {
    fun inject(fragment: BookingFragment)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): BookingComponent
    }
}

