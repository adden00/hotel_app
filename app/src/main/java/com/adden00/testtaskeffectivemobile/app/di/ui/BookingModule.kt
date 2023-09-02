package com.adden00.testtaskeffectivemobile.app.di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.testtaskeffectivemobile.app.di.ViewModelKey
import com.adden00.testtaskeffectivemobile.core.ViewModelFactory
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.BookingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface BookingModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(BookingViewModel::class)
    @Binds
    fun bindBookingViewModel(impl: BookingViewModel): ViewModel
}