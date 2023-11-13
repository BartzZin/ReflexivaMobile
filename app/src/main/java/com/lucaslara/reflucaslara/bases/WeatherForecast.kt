package com.lucaslara.reflucaslara.bases

import com.google.gson.annotations.SerializedName

data class WeatherForecast(
    @SerializedName("date") val date: String,
    @SerializedName("weekday") val weekday: String,
    @SerializedName("max") val max: Int,
    @SerializedName("min") val min: Int,
    @SerializedName("cloudiness") val cloudiness: Double,
    @SerializedName("rain") val rain: Double,
    @SerializedName("rain_probability") val rainProbability: Int,
    @SerializedName("wind_speedy") val windSpeedy: String,
    @SerializedName("description") val description: String,
    @SerializedName("condition") val condition: String
)