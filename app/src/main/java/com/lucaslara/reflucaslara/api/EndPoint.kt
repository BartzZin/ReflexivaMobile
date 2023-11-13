package com.lucaslara.reflucaslara.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {
    @GET("/weather?woeid=457197")
    fun getClima(): Call<JsonObject>

}