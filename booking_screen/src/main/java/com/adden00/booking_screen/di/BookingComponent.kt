package com.adden00.booking_screen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.booking_screen.presentation.BookingFragment
import com.adden00.booking_screen.presentation.BookingViewModel
import com.adden00.core.ViewModelFactory
import com.adden00.core.di.ScreenScope
import com.adden00.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap


@Subcomponent(modules = [BookingModule::class])
@ScreenScope
interface BookingComponent {
    fun inject(fragment: BookingFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): BookingComponent
    }
}

@Module
interface BookingModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(BookingViewModel::class)
    @Binds
    fun bindBookingViewModel(impl: BookingViewModel): ViewModel
}

