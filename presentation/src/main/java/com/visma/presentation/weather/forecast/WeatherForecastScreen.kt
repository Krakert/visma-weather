package com.visma.presentation.weather.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.visma.presentation.theme.BlackForecastScreen
import com.visma.presentation.theme.GreyForecastScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherForecastScreen(
    navController: NavHostController,
    viewModel: WeatherForecastViewModel,
    city: String
) {

    LaunchedEffect(Unit){
        viewModel.fetchWeatherForecast(city)
    }

    Column(
        modifier = Modifier
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        IconButton(modifier = Modifier.size(54.dp),
            onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = GreyForecastScreen,
                contentDescription = "Back",
                modifier = Modifier
                    .size(32.dp)
            )
        }
        Text(
            text = "Forecast next 14 days",
            style = MaterialTheme.typography.displayLarge.copy(
                color = BlackForecastScreen,
                fontWeight = FontWeight.Black
            )
        )
    }

}