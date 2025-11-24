package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.weather.navigation.AppNavGraph
import com.example.weather.navigation.NavRoutes
import com.example.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavRoutes.SEARCH_CITIES
                ) {
                    AppNavGraph(navController).setup(this)
                }
            }
        }
    }
}

