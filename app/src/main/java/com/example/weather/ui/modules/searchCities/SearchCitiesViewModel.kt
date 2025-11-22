package com.example.weather.ui.modules.searchCities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.model.GeocodingLocation
import com.example.weather.domain.usecase.WeatherUseCase
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormEvent
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormState
import com.example.weather.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCitiesViewModel @Inject constructor(
    private val useCase: WeatherUseCase
) : ViewModel() {

    private val _formState = MutableStateFlow(SearchCitiesFormState())
    val formState = _formState.asStateFlow()

    private val _cityCoordinatesState = MutableStateFlow<UiState<GeocodingLocation>>(UiState.Idle)
    val cityCoordinatesState = _cityCoordinatesState.asStateFlow()

    fun onFormEvent(event: SearchCitiesFormEvent) {
        when (event) {
            is SearchCitiesFormEvent.OnCityFormChanged -> {
                _formState.value = _formState.value.copy(
                    cityQuery = event.city
                )
            }

            is SearchCitiesFormEvent.SendCityFormEvent -> {
                searchCityCoordinates()
            }

            is SearchCitiesFormEvent.OnCloseDialogError -> {

            }
        }
    }

    private fun searchCityCoordinates() {
        viewModelScope.launch {
            val cityQuery = _formState.value.cityQuery

            if (cityQuery.isNotBlank()) {
                _cityCoordinatesState.update { UiState.Loading }

                useCase.getCityCoordinates(
                    cityQuery,
                ).fold(
                    onSuccess = { data ->
                        _cityCoordinatesState.update {
                            UiState.Success(data)
                        }
                    },
                    onFailure = { error ->
                        _cityCoordinatesState.update {
                            UiState.Error(error.message ?: "Something went wrong")
                        }
                    }
                )

            } else {
                _cityCoordinatesState.update {
                    UiState.Error("Invalid input")
                }
            }
        }
    }

    fun clearCityCoordinatesState() {
        _cityCoordinatesState.value = UiState.Idle
    }

}