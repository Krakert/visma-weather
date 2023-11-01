package com.visma.presentation.weather.formatter

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class UnixTimeToHourStampFormatter @Inject constructor() {
    fun map(timestamp: Long): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.US)
        val date = Date(timestamp * 1000) // Convert Unix timestamp to milliseconds
        return dateFormat.format(date)
    }
}