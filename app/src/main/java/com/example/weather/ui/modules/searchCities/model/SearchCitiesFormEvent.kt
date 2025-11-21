package com.example.weather.ui.modules.searchCities.model

sealed interface SearchCitiesFormEvent {
    data class OnCityFormChanged(val city: String) : SearchCitiesFormEvent
    data object SendCityFormEvent : SearchCitiesFormEvent
    data object OnCloseDialogError : SearchCitiesFormEvent
}