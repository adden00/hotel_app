package com.adden00.testtaskeffectivemobile.app.di.ui

import com.adden00.testtaskeffectivemobile.app.di.AppComponent
import com.adden00.testtaskeffectivemobile.app.di.ScreenScope
import com.adden00.testtaskeffectivemobile.features.hotel_screen.presentation.HotelFragment
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

