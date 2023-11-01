package com.visma.presentation.weather.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.extension.capitalize
import com.visma.presentation.nav.Screen
import com.visma.presentation.theme.BlueGradientBottom
import com.visma.presentation.theme.BlueGradientTop
import com.visma.presentation.weather.overview.components.WeatherDayForecastRow
import com.visma.presentation.weather.overview.components.WeatherOverviewSummary
import com.visma.weather.presentation.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherOverviewScreen(navController: NavHostController, viewModel: WeatherOverviewViewModel) {

    val contentTodayState by viewModel.weatherOverviewTodayContentState.collectAsState()
    val contentForecast by viewModel.weatherOverviewForecastToday.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    var value by rememberSaveable { mutableStateOf("London") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val focusManager = LocalFocusManager.current

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
            Row(modifier = Modifier.padding(top = 64.dp, start = 24.dp, end = 24.dp)) {
                BasicTextField(
                    textStyle = MaterialTheme.typography.displayLarge,
                    singleLine = true,
                    value = TextFieldValue(
                        text = value, selection = TextRange(value.length)
                    ),
                    onValueChange = { newValue ->
                        value = newValue.text.trim().capitalize()
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        viewModel.fetchWeatherOverview(value)
                        viewModel.fetchWeatherForecast(value)
                        focusManager.clearFocus(true)
                        keyboardController?.hide()
                    })
                )
            }
            Spacer(modifier = Modifier.height(100.dp))

            when (val state = contentTodayState) {
                is OnDisplay -> {
                    WeatherOverviewSummary(
                        icon = state.display.icon,
                        temp = state.display.temperature,
                        desc = state.display.description
                    )
                }
                is OnError -> {
                    TODO()
                }
                OnLoading -> {
                    Text(text = "Loading")
                }
            }
            Spacer(modifier = Modifier.height(75.dp))
            Row(
                modifier = Modifier
                    .padding(start = 54.dp, end = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = Modifier.padding(end = 16.dp),
                    text = stringResource(R.string.txt_forecast),
                    style = MaterialTheme.typography.labelSmall.copy(Color.White)
                )
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.Forecast.route)
                    }, text = stringResource(R.string.txt_upcoming_days), style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            when (val state = contentForecast) {
                is OnDisplay -> {
                    WeatherDayForecastRow(forecast = state.display.result)
                }
                is OnError -> {}
                OnLoading -> {}
            }
        }

    }
}
