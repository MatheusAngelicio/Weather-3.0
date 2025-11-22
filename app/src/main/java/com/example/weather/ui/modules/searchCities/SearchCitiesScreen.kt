package com.example.weather.ui.modules.searchCities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.R
import com.example.weather.domain.model.GeocodingLocation
import com.example.weather.ui.components.ErrorDialog
import com.example.weather.ui.components.LoadingOverlay
import com.example.weather.ui.components.WeatherTextField
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormEvent
import com.example.weather.ui.modules.searchCities.model.SearchCitiesFormState
import com.example.weather.ui.state.UiState
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun SearchCitiesScreen() {
    val viewModel = viewModel<SearchCitiesViewModel>()

    val formState by viewModel.formState.collectAsStateWithLifecycle()
    val cityCoordinatesState by viewModel.cityCoordinatesState.collectAsStateWithLifecycle()

    var showErrorDialog by remember { mutableStateOf<String?>(null) }


    LaunchedEffect(cityCoordinatesState) {
        when (cityCoordinatesState) {
            is UiState.Success -> {
                val data = (cityCoordinatesState as UiState.Success).data
                println("Cidade encontrada: ${data.name}/${data.country}---${data.lat}, ${data.lon}")
                // Navegar para proxima tela passando latitute e longitude
            }

            is UiState.Error -> {
                val message = (cityCoordinatesState as UiState.Error).message
                showErrorDialog = message
            }

            else -> Unit
        }
    }

    SearchCitiesContent(
        formState = formState,
        cityCoordinatesState = cityCoordinatesState,
        onFormEvent = viewModel::onFormEvent
    )

    showErrorDialog?.let { message ->
        ErrorDialog(
            message = message,
            onDismiss = { showErrorDialog = null }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCitiesContent(
    formState: SearchCitiesFormState,
    cityCoordinatesState: UiState<GeocodingLocation>,
    onFormEvent: (SearchCitiesFormEvent) -> Unit
) {

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

        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                    .consumeWindowInsets(innerPadding)
                    .systemBarsPadding()
            ) {

                WeatherTextField(
                    value = formState.cityQuery,
                    onValueChange = {
                        onFormEvent(SearchCitiesFormEvent.OnCityFormChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onDone = { text ->
                        println("Usuário clicou em DONE com valor: $text")
                        onFormEvent(SearchCitiesFormEvent.SendCityFormEvent)
                    },
                    placeholder = "Search for a city",
                    icon = R.drawable.ic_search
                )
            }

            LoadingOverlay(
                isLoading = cityCoordinatesState is UiState.Loading
            )
        }
    }
}


@Preview
@Composable
private fun SearchCitiesContentPreview() {
    WeatherTheme {
        SearchCitiesContent(
            formState = SearchCitiesFormState(
                cityQuery = "São Paulo"
            ),
            onFormEvent = {},
            cityCoordinatesState = UiState.Idle,
        )
    }
}