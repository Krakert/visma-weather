package com.visma.presentation.weather.overview.formatter

import javax.inject.Inject

class DegreeFormatter @Inject constructor() {
    fun map(temp: String): String {
        return "$temp°"
    }
}