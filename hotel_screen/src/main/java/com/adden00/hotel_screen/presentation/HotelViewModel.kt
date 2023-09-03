package com.adden00.hotel_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.hotel_screen.domain.HotelRepository
import com.adden00.hotel_screen.presentation.mvi.HotelEvent
import com.adden00.hotel_screen.presentation.mvi.HotelState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HotelViewModel @Inject constructor(private val repository: HotelRepository) : ViewModel() {

    private val _hotelScreenState = MutableStateFlow<HotelState>(HotelState.Init)
    val hotelScreenState: StateFlow<HotelState> get() = _hotelScreenState.asStateFlow()

    init {
        newEvent(HotelEvent.LoadHotelInfo)
    }

    fun newEvent(event: HotelEvent) {
        when (event) {
            is HotelEvent.LoadHotelInfo -> {
                if (hotelScreenState.value !is HotelState.Loaded) {
                    _hotelScreenState.value = HotelState.Loading
                }
                viewModelScope.launch {
                    try {
                        val result = repository.loadHotels().toPresentation()
                        _hotelScreenState.value = HotelState.Loaded(result)
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        _hotelScreenState.value = HotelState.Error
                    }
                }
            }
        }
    }
}