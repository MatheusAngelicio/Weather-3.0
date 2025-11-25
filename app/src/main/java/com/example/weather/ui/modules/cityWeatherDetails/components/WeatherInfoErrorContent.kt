package com.example.weather.ui.modules.cityWeatherDetails.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather.R
import com.example.weather.ui.components.ErrorStateView
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun WeatherInfoErrorContent(
    text: String,
    onTryAgainClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ErrorStateView(
            R.drawable.ic_cloud_off,
            title = "Oops! Can't reach the sky",
            description = text,
            onButtonClick = onTryAgainClick
        )
    }
}

@Preview
@Composable
private fun WeatherInfoErrorContentPreview() {
    WeatherTheme {
        WeatherInfoErrorContent(
            text = "Something went wrong",
            onTryAgainClick = {}
        )
    }
}