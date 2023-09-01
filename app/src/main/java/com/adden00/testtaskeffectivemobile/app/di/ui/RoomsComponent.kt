package com.adden00.testtaskeffectivemobile.app.di.ui

import com.adden00.testtaskeffectivemobile.app.di.AppComponent
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.RoomsFragment
import com.addisov00.testtaskmts.common.di.ScreenScope
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [RoomsModule::class])
@ScreenScope
interface RoomsComponent {
    fun inject(fragment: RoomsFragment)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): RoomsComponent
    }
}
