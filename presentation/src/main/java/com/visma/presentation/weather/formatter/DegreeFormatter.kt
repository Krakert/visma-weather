package com.visma.presentation.weather.formatter

import javax.inject.Inject

class DegreeFormatter @Inject constructor() {
    fun map(temp: String): String {
        return "$temp°"
    }
}