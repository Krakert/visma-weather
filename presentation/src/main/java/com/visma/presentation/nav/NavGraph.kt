package com.visma.presentation.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.visma.presentation.theme.WeatherAppTheme
import com.visma.presentation.weather.forecast.WeatherForecastScreen
import com.visma.presentation.weather.overview.WeatherOverviewScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    WeatherAppTheme {
        NavHost(navController = navController, startDestination = Screen.Overview.route) {
            composable(Screen.Overview.route) {
                WeatherOverviewScreen(
                    navController = navController,
                    viewModel = hiltViewModel()
                )
            }
            composable(Screen.Forecast.route) {
                val result = navController.previousBackStackEntry?.savedStateHandle?.get<String>("City")
                if (result != null) {
                    WeatherForecastScreen(
                        navController = navController,
                        viewModel = hiltViewModel(),
                        city = result,
                    )
                }
            }
        }
    }
}