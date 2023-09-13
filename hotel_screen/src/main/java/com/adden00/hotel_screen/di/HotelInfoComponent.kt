package com.adden00.hotel_screen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.core.ViewModelFactory
import com.adden00.core.di.ScreenScope
import com.adden00.core.di.ViewModelKey
import com.adden00.hotel_screen.presentation.HotelFragment
import com.adden00.hotel_screen.presentation.HotelViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap


@Subcomponent(modules = [HotelInfoModule::class])
@ScreenScope
interface HotelInfoComponent {
    fun inject(fragment: HotelFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HotelInfoComponent
    }
}

@Module
interface HotelInfoModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(HotelViewModel::class)
    @Binds
    fun bindHotelViewModel(impl: HotelViewModel): ViewModel

}
