package com.visma.presentation.weather.forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.visma.presentation.OnDisplay
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.extension.shimmerEffect
import com.visma.presentation.theme.BlueGradientBottom
import com.visma.presentation.theme.BlueGradientTop
import com.visma.presentation.theme.LocalDimensions
import com.visma.presentation.theme.dimensions
import com.visma.presentation.weather.forecast.components.WeatherForecastTopBar
import com.visma.presentation.weather.overview.components.WeatherDayForecastRow

@Composable
fun WeatherForecastScreen(
    navController: NavHostController,
    viewModel: WeatherForecastViewModel,
    city: String
) {

    val contentForecast by viewModel.weatherOverviewForecast.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeatherForecast(city)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BlueGradientTop, BlueGradientBottom)
                )
            )
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.spacingLarge),
        ) {
            WeatherForecastTopBar {
                navController.navigateUp()
            }
            when (val state = contentForecast) {
                is OnDisplay -> {
                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = MaterialTheme.dimensions.spacingLarge)) {
                        state.display.result.forEach {
                            item {
                                Box(modifier = Modifier.padding(MaterialTheme.dimensions.spacingMedium)) {
                                    Text(
                                        modifier = Modifier.padding(start = LocalDimensions.current.spacingForecastRow),
                                        text = it.date,
                                        style = MaterialTheme.typography.displayLarge

                                    )
                                }
                                WeatherDayForecastRow(false, it.forecasts)
                            }
                        }
                    }
                }

                is OnError -> {
                }

                OnLoading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = LocalDimensions.current.spacingForecastRow)
                            .clip(RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp))
                            .shimmerEffect()
                    )
                }
            }
        }
    }

}