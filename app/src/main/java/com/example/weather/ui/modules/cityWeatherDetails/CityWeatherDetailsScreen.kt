package com.example.weather.ui.modules.cityWeatherDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import com.example.weather.ui.modules.cityWeatherDetails.components.WeatherInfoSuccessContent
import com.example.weather.ui.state.UiState
import com.example.weather.ui.theme.BlueSky
import com.example.weather.ui.theme.GraySky
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun CityWeatherDetailsScreen(
    lat: Float,
    lon: Float,
    onBack: () -> Unit,
    viewModel: CityWeatherDetailsViewModel = hiltViewModel()
) {
    val currentWeatherState by viewModel.currentWeatherState.collectAsStateWithLifecycle()

    // CHAMAR APENAS UMA VEZ
    //LaunchedEffect é tipo um "executar isso só quando a tela abrir".
    //É o equivalente ao onCreate()
    LaunchedEffect(lat, lon) {
        viewModel.fetchWeatherDetails(lat, lon)
    }

    CityWeatherDetailsContent(
        currentWeatherState = currentWeatherState,
        onBack = onBack,
    )
}

@Composable
fun CityWeatherDetailsContent(
    currentWeatherState: UiState<CurrentWeather>,
    onBack: () -> Unit
) {
    val successData = (currentWeatherState as? UiState.Success)?.data
    val backgroundColor = if (successData?.isDay == true) BlueSky else GraySky

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
                        // Mostrar os componentes de erro

                    }

                    is UiState.Idle -> {
                        LoadingOverlay(false)

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CityWeatherDetailsContentPreview() {
    WeatherTheme {
        CityWeatherDetailsContent(UiState.Idle, {})
    }
}