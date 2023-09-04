package com.adden00.rooms_screen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adden00.core.ViewModelFactory
import com.adden00.core.di.ScreenScope
import com.adden00.core.di.ViewModelKey
import com.adden00.rooms_screen.presentation.RoomsFragment
import com.adden00.rooms_screen.presentation.RoomsViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap


@Subcomponent(modules = [RoomsModule::class])
@ScreenScope
interface RoomsComponent {
    fun inject(fragment: RoomsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): RoomsComponent
    }
}

@Module
interface RoomsModule {
    @Binds
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(RoomsViewModel::class)
    @Binds
    fun bindRoomsViewModel(impl: RoomsViewModel): ViewModel

}
