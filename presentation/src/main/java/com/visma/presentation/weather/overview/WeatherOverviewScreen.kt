package com.visma.presentation.weather.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.components.WeatherForecastRow
import com.visma.presentation.nav.Screen
import com.visma.presentation.theme.BlueGradientBottom
import com.visma.presentation.theme.BlueGradientTop
import com.visma.presentation.weather.overview.components.WeatherOverviewDateRow
import com.visma.presentation.weather.overview.components.WeatherOverviewSummary
import com.visma.presentation.weather.overview.components.WeatherOverviewTextRow
import com.visma.presentation.weather.overview.components.WeatherSearchBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherOverviewScreen(navController: NavHostController, viewModel: WeatherOverviewViewModel) {

    val contentTodayState by viewModel.weatherOverviewTodayContentState.collectAsState()
    val contentForecast by viewModel.weatherOverviewForecastToday.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val focusManager = LocalFocusManager.current
    var textInput by remember { mutableStateOf("London") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BlueGradientTop, BlueGradientBottom)
                )
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                keyboardController?.hide()
                focusManager.clearFocus(true)
            }
    ) {
        // Search bar for the city
        Column {
            WeatherSearchBar(text = textInput,
                onValueChange = { textInput = it },
                onDone = {
                    viewModel.loadData(textInput)
                    focusManager.clearFocus(true)
                    keyboardController?.hide()
                }
            )
            // Overview of the weather
            when (val state = contentTodayState) {
                is OnDisplay -> {
                    WeatherOverviewDateRow(isLoading = isLoading, date = state.display.date)
                    Spacer(modifier = Modifier.height(50.dp))
                    WeatherOverviewSummary(
                        isLoading = isLoading,
                        icon = state.display.icon,
                        temp = state.display.temperature,
                        desc = state.display.description
                    )
                }

                is OnError -> {}
                OnLoading -> {}
            }
            Spacer(modifier = Modifier.height(75.dp))
            // Navigate to other forecast
            WeatherOverviewTextRow(
                isLoading = isLoading
            ) {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "City", value = textInput
                )
                navController.navigate(Screen.Forecast.route)
            }
            Spacer(modifier = Modifier.height(32.dp))
            // Forecast of upcoming hours
            when (val state = contentForecast) {
                is OnDisplay -> {
                    WeatherForecastRow(
                        isLoading = isLoading,
                        forecast = state.display.result)
                }

                is OnError -> {}
                OnLoading -> {}
            }
        }

    }
}
