package com.visma.presentation.weather.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visma.domain.weather.GetForecastByCity
import com.visma.presentation.ContentState
import com.visma.presentation.OnError
import com.visma.presentation.OnLoading
import com.visma.presentation.weather.forecast.mapper.WeatherForecastDisplayMapper
import com.visma.presentation.weather.overview.model.WeatherForecast24hDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherForecastViewModel @Inject constructor(
    private val getForecastByCity: GetForecastByCity,
    private val weatherForecastDisplayMapper: WeatherForecastDisplayMapper
    ) : ViewModel() {

    private val mutableForecastFlow = MutableStateFlow<ContentState<WeatherForecast24hDisplay>>(OnLoading)
    val weatherOverviewForecastToday: StateFlow<ContentState<WeatherForecast24hDisplay>> = mutableForecastFlow

    fun fetchWeatherForecast(city: String) {
        viewModelScope.launch {
            getForecastByCity(city, 40).onSuccess {
                Timber.i(it.toString())
//                mutableForecastFlow.emit(
//                    OnDisplay(weatherForecastDisplayMapper.map(it))
//                )
            }.onFailure { mutableForecastFlow.emit(OnError(it)) }
        }
    }
}