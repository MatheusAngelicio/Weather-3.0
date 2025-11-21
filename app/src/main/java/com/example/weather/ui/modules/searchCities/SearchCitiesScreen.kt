package com.example.weather.ui.modules.searchCities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.ui.components.WeatherTextField
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun SearchCitiesScreen() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCitiesContent() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Weather App",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .consumeWindowInsets(innerPadding)
                .systemBarsPadding()
        ) {
            WeatherTextField(
                value = "",
                onValueChange = { },
                placeholder = "Search for a city",
                icon = R.drawable.ic_search
            )
        }
    }
}

@Preview
@Composable
private fun SearchCitiesContentPreview() {
    WeatherTheme {
        SearchCitiesContent()
    }

}