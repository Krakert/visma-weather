package com.visma.presentation.weather.formatter

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class UnixTimeToDateFormatter @Inject constructor() {
    fun map(timestamp: Long): String {
        // Create a SimpleDateFormat object with the desired format
        val dateFormat = SimpleDateFormat("E, d MMM", Locale.US)

        // Set the timezone to UTC (you can change this to your desired timezone)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")

        // Convert the Unix timestamp to a Date object
        val date = Date(timestamp * 1000)

        // Format the Date object as a string
        return dateFormat.format(date)
    }
}