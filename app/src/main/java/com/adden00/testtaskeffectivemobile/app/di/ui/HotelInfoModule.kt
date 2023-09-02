package com.adden00.testtaskeffectivemobile.app.di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.testtaskeffectivemobile.app.di.ViewModelKey
import com.adden00.testtaskeffectivemobile.core.ViewModelFactory
import com.adden00.testtaskeffectivemobile.features.hotel_screen.presentation.HotelViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HotelInfoModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(HotelViewModel::class)
    @Binds
    fun bindHotelViewModel(impl: HotelViewModel): ViewModel

}