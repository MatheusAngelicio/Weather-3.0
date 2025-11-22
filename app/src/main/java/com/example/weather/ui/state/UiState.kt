package com.example.weather.ui.state

sealed interface UiState {
    object Idle : UiState
    object Loading : UiState
    object Success : UiState
    data class Error(val message: String) : UiState
}