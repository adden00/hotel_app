package com.adden00.testtaskeffectivemobile.app.di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.testtaskeffectivemobile.app.di.ViewModelKey
import com.adden00.testtaskeffectivemobile.core.ViewModelFactory
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.RoomsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RoomsModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(RoomsViewModel::class)
    @Binds
    fun bindRoomsViewModel(impl: RoomsViewModel): ViewModel

}