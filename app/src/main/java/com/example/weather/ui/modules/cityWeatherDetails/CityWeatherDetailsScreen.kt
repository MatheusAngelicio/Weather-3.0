package com.example.weather.ui.modules.cityWeatherDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weather.core.utils.WeatherUtils.getUrlIcon
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.ui.components.LoadingOverlay
import com.example.weather.ui.components.WeatherTopBar
import com.example.weather.ui.modules.cityWeatherDetails.components.MainWeatherInfo
import com.example.weather.ui.modules.cityWeatherDetails.components.WeatherInfoErrorContent
import com.example.weather.ui.modules.cityWeatherDetails.components.WeatherInfoSuccessContent
import com.example.weather.ui.modules.cityWeatherDetails.model.CityWeatherDetailsFormEvent
import com.example.weather.ui.state.UiState
import com.example.weather.ui.theme.BlueSky
import com.example.weather.ui.theme.GraySky
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun CityWeatherDetailsScreen(
    onBack: () -> Unit,
    viewModel: CityWeatherDetailsViewModel = hiltViewModel()
) {
    val currentWeatherState by viewModel.currentWeatherState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchWeatherDetails()
    }

    CityWeatherDetailsContent(
        currentWeatherState = currentWeatherState,
        onFormEvent = viewModel::onFormEvent,
        onBack = onBack,
    )
}

@Composable
fun CityWeatherDetailsContent(
    currentWeatherState: UiState<CurrentWeather>,
    onFormEvent: (CityWeatherDetailsFormEvent) -> Unit,
    onBack: () -> Unit
) {
    val successData = (currentWeatherState as? UiState.Success)?.data
    val backgroundColor = when {
        successData == null -> MaterialTheme.colorScheme.background
        successData.isDay -> BlueSky
        else -> GraySky
    }

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            WeatherTopBar(
                title = successData?.cityName ?: "City Details",
                subtitle = successData?.country,
                color = backgroundColor,
                onBack = onBack,
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                    .consumeWindowInsets(innerPadding)
                    .systemBarsPadding()
            ) {
                when (currentWeatherState) {
                    is UiState.Loading -> LoadingOverlay(true)

                    is UiState.Success -> {
                        LoadingOverlay(false)
                        WeatherInfoSuccessContent(currentWeatherState.data)
                    }

                    is UiState.Error -> {
                        LoadingOverlay(false)
                        WeatherInfoErrorContent(
                            text = currentWeatherState.message,
                            onTryAgainClick = {
                                onFormEvent(CityWeatherDetailsFormEvent.OnRetryFetchWeatherDetails)
                            }
                        )
                    }

                    is UiState.Idle -> {
                        LoadingOverlay(false)

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityWeatherDetailsContentSuccessIsDayPreview() {
    WeatherTheme {
        CityWeatherDetailsContent(
            currentWeatherState = UiState.Success(
                CurrentWeather(
                    cityName = "São Paulo",
                    country = "BR",
                    temperature = 25.3,
                    feelsLike = 27.0,
                    tempMin = 22.0,
                    tempMax = 29.0,
                    humidity = 60,
                    description = "Clear sky",
                    icon = "01d",
                    windSpeed = 3.4,
                    windDeg = 180,
                    lat = -23.5505,
                    lon = -46.6333,
                    isDay = true
                )
            ),
            onBack = {},
            onFormEvent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CityWeatherDetailsContentSuccessIsNightPreview() {
    WeatherTheme {
        CityWeatherDetailsContent(
            currentWeatherState = UiState.Success(
                CurrentWeather(
                    cityName = "São Paulo",
                    country = "BR",
                    temperature = 25.3,
                    feelsLike = 27.0,
                    tempMin = 22.0,
                    tempMax = 29.0,
                    humidity = 60,
                    description = "Clear sky",
                    icon = "01d",
                    windSpeed = 3.4,
                    windDeg = 180,
                    lat = -23.5505,
                    lon = -46.6333,
                    isDay = false
                )
            ),
            onBack = {},
            onFormEvent = {}
        )
    }
}

@Preview
@Composable
private fun CityWeatherDetailsContentErrorPreview() {
    WeatherTheme {
        CityWeatherDetailsContent(
            UiState.Error("error"),
            {},
            {})
    }
}