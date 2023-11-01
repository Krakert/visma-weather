package com.visma.data.weather.mapper

import com.visma.data.component.DataConfig.ICON_BASE_URL
import javax.inject.Inject

class WeatherIconMapper @Inject constructor(

) {
    fun getIconUrl(icon: String): String = ICON_BASE_URL.replace("$", icon)
}