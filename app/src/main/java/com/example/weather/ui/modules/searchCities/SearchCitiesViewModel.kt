package com.example.weather.ui.modules.searchCities

import androidx.lifecycle.ViewModel
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormEvent
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchCitiesViewModel: ViewModel() {

    private val _formState = MutableStateFlow(SearchCitiesFormState())
    val formState = _formState.asStateFlow()


    fun onFormEvent(event: SearchCitiesFormEvent) {
        when (event) {
            is SearchCitiesFormEvent.OnCityFormChanged -> {
                _formState.value = _formState.value.copy(
                    cityQuery = event.city
                )
            }
            is SearchCitiesFormEvent.SendCityFormEvent -> {
                //Chamar api
            }
            is SearchCitiesFormEvent.OnCloseDialogError -> {

            }
        }
    }
}