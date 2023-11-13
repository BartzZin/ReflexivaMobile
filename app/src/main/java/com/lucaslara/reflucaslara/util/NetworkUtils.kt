package com.lucaslara.reflucaslara.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object{
        fun getRetrofitInstance(urlPadrao: String): Retrofit{

            return Retrofit.Builder()
                .baseUrl(urlPadrao)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

