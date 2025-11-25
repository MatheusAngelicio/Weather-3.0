package com.example.weather.ui.modules.cityWeatherDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.domain.usecase.WeatherUseCase
import com.example.weather.ui.modules.cityWeatherDetails.model.CityWeatherDetailsFormEvent
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormEvent
import com.example.weather.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityWeatherDetailsViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _currentWeatherState = MutableStateFlow<UiState<CurrentWeather>>(UiState.Idle)
    val currentWeatherState = _currentWeatherState.asStateFlow()

    private val lat = savedStateHandle.get<Float>("lat") ?: 0f
    private val lon = savedStateHandle.get<Float>("lon") ?: 0f

    fun onFormEvent(event: CityWeatherDetailsFormEvent) {
        when (event) {
            CityWeatherDetailsFormEvent.OnRetryFetchWeatherDetails -> {
                fetchWeatherDetails()
            }
        }
    }

    fun fetchWeatherDetails() {
        viewModelScope.launch {
            _currentWeatherState.value = UiState.Loading
            weatherUseCase.getWeatherDetails(lat, lon).fold(
                onSuccess = {
                    _currentWeatherState.value = UiState.Success(it)
                },
                onFailure = {
                    _currentWeatherState.value = UiState.Error(it.message ?: "Unknown error")
                }
            )
        }
    }

}