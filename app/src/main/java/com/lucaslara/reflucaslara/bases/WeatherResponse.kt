package com.lucaslara.reflucaslara.bases

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
    @SerializedName("by") val by: String,
    @SerializedName("valid_key") val validKey: Boolean,
    @SerializedName("results") val results: WeatherResults,
    @SerializedName("execution_time") val executionTime: Double,
    @SerializedName("from_cache") val fromCache: Boolean
) : Serializable