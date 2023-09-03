package com.adden00.testtaskeffectivemobile.app.di.ui

import com.adden00.hotel_screen.presentation.HotelFragment
import com.adden00.testtaskeffectivemobile.app.di.AppComponent
import com.adden00.testtaskeffectivemobile.app.di.ScreenScope
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [HotelInfoModule::class])
@ScreenScope
interface HotelInfoComponent {
    fun inject(fragment: HotelFragment)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): HotelInfoComponent
    }
}

