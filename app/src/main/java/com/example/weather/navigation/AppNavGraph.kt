package com.example.weather.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.weather.ui.modules.cityWeatherDetails.CityWeatherDetailsScreen
import com.example.weather.ui.modules.searchCities.SearchCitiesScreen

class AppNavGraph(private val navController: NavHostController) {
    fun setup(navGraphBuilder: NavGraphBuilder) {
        with(navGraphBuilder) {
            composable(NavRoutes.SEARCH_CITIES) {
                SearchCitiesScreen(
                    navigateToCityDetails = { lat, lon ->
                        navController.navigate(NavRoutes.cityWeatherDetailsRoute(lat, lon))
                    }
                )
            }
            composable(
                route = "${NavRoutes.CITY_WEATHER_DETAILS}/{lat}/{lon}",
                arguments = listOf(
                    navArgument("lat") { type = NavType.FloatType },
                    navArgument("lon") { type = NavType.FloatType }
                )
            ) {
                CityWeatherDetailsScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
