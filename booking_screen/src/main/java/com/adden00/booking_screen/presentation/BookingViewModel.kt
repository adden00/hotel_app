package com.adden00.booking_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.booking_screen.domain.BookingRepository
import com.adden00.booking_screen.presentation.models.TouristCollapseType
import com.adden00.booking_screen.presentation.mvi.BookingEffect
import com.adden00.booking_screen.presentation.mvi.BookingEvent
import com.adden00.booking_screen.presentation.mvi.BookingState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookingViewModel @Inject constructor(private val repository: BookingRepository) :
    ViewModel() {

    private val _bookingScreenState = MutableStateFlow(BookingState())
    val bookingScreenState: StateFlow<BookingState> get() = _bookingScreenState.asStateFlow()

    private val _screenEffect = MutableStateFlow<BookingEffect>(BookingEffect.Init)
    val screenEffects: StateFlow<BookingEffect>
        get() = _screenEffect.asStateFlow()

    init {
        newEvent(BookingEvent.LoadBookingDetails)
    }

    fun newEvent(event: BookingEvent) {
        when (event) {
            BookingEvent.LoadBookingDetails -> {
                _bookingScreenState.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    try {
                        val result = repository.loadBookingData().toPresentation()
                        _bookingScreenState.update { it.copy(bookingInfo = result) }
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        _screenEffect.value = BookingEffect.ShowError
                    } finally {
                        _bookingScreenState.update { it.copy(isLoading = false) }
                        _screenEffect.value = BookingEffect.Init
                    }
                }
            }

            is BookingEvent.AddTourist -> {
                _bookingScreenState.update {
                    it.copy(
                        bookingInfo = it.bookingInfo?.copy(
                            touristList = it.bookingInfo.touristList.toMutableList()
                                .apply { add(TouristCollapseType.Expanded(size)) }.toList()
                        )
                    )
                }
            }

            is BookingEvent.CollapseTourist -> {
                _bookingScreenState.update {
                    it.copy(
                        bookingInfo = it.bookingInfo?.copy(
                            touristList = it.bookingInfo.touristList.toMutableList()
                                .apply {
                                    this[event.touristNumber] =
                                        TouristCollapseType.Collapsed(event.touristNumber)
                                }.toList()
                        )
                    )
                }
            }

            is BookingEvent.ExpandTourist -> {
                _bookingScreenState.update {
                    it.copy(
                        bookingInfo = it.bookingInfo?.copy(
                            touristList = it.bookingInfo.touristList.toMutableList()
                                .apply {
                                    this[event.touristNumber] =
                                        TouristCollapseType.Expanded(event.touristNumber)
                                }.toList()
                        )
                    )
                }
            }
        }
    }
}