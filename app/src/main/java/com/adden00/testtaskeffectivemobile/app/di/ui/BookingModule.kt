package com.adden00.testtaskeffectivemobile.app.di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.booking_screen.presentation.BookingViewModel
import com.adden00.core.ViewModelFactory
import com.adden00.testtaskeffectivemobile.app.di.ViewModelKey
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