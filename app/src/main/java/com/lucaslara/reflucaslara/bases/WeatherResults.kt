package com.lucaslara.reflucaslara.bases

import com.google.gson.annotations.SerializedName

data class WeatherResults(
    @SerializedName("temp") val temp: Int,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String,
    @SerializedName("condition_code") val conditionCode: String,
    @SerializedName("description") val description: String,
    @SerializedName("currently") val currently: String,
    @SerializedName("cid") val cid: String,
    @SerializedName("city") val city: String,
    @SerializedName("img_id") val imgId: String,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("cloudiness") val cloudiness: Double,
    @SerializedName("rain") val rain: Double,
    @SerializedName("wind_speedy") val windSpeedy: String,
    @SerializedName("wind_direction") val windDirection: Int,
    @SerializedName("wind_cardinal") val windCardinal: String,
    @SerializedName("sunrise") val sunrise: String,
    @SerializedName("sunset") val sunset: String,
    @SerializedName("moon_phase") val moonPhase: String,
    @SerializedName("condition_slug") val conditionSlug: String,
    @SerializedName("city_name") val cityName: String,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("forecast") val forecast: List<WeatherForecast>,
    @SerializedName("cref") val cref: String
)