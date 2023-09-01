package com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.testtaskeffectivemobile.features.rooms_screen.domain.RoomsRepository
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.mvi.RoomsEffect
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.mvi.RoomsEvent
import com.adden00.testtaskeffectivemobile.features.rooms_screen.presentation.mvi.RoomsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class RoomsViewModel @Inject constructor(private val repository: RoomsRepository) : ViewModel() {

    private val _roomsScreenState = MutableStateFlow(RoomsState())
    val roomsScreenState: StateFlow<RoomsState> get() = _roomsScreenState.asStateFlow()

    private val _screenEffect = MutableStateFlow<RoomsEffect>(RoomsEffect.Init)
    val screenEffects: StateFlow<RoomsEffect>
        get() = _screenEffect.asStateFlow()

    init {
        newEvent(RoomsEvent.LoadRooms)
    }

    fun newEvent(event: RoomsEvent) {
        when (event) {
            is RoomsEvent.LoadRooms -> {
                _roomsScreenState.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    try {
                        val result = repository.loadRooms().map { it.toPresentation() }
                        _roomsScreenState.update { it.copy(rooms = result) }
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        _screenEffect.value = RoomsEffect.ShowError
                    } finally {
                        _roomsScreenState.update { it.copy(isLoading = false) }
                        _screenEffect.value = RoomsEffect.Init
                    }
                }
            }
        }
    }
}