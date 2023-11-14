package com.lucaslara.reflucaslara

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.lucaslara.reflucaslara.api.EndPoint
import com.lucaslara.reflucaslara.bases.WeatherResponse
import com.lucaslara.reflucaslara.databinding.ActivityMainBinding
import com.lucaslara.reflucaslara.util.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var gMapTeste: GoogleMap
    val baseClima : String = "https://api.hgbrasil.com"
    lateinit var ctx: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ctx = application.applicationContext
        getClimas()

    }

    private fun replaceFragmante(fragmant: Fragment){
        val fragmanteManager = supportFragmentManager
        val fragmentTransaction = fragmanteManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragmant)
        fragmentTransaction.commit()
    }

    fun getClimas() {
        val retrofitClient = NetworkUtils.getRetrofitInstance(baseClima)
        val endpoint = retrofitClient.create(EndPoint::class.java)
        var vweatherResponse : WeatherResponse? = null

        endpoint.getClima().enqueue(object : retrofit2.Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    val gson = Gson()
                    val weatherResponse: WeatherResponse? = gson.fromJson(
                        response.body(),
                        WeatherResponse::class.java
                    )

                    vweatherResponse = weatherResponse

                    if (weatherResponse != null) {
                        // Exemplo: Imprimir a temperatura
                        val temperaturaAtual = weatherResponse.results.temp
                        Toast.makeText(ctx, "Temperatura atual: $temperaturaAtual", Toast.LENGTH_SHORT).show()

                        replaceFragmante(Pagina1(weatherResponse))
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()


                        binding.BottomNavigationView.setOnItemSelectedListener {
                            when(it.itemId){
                                R.id.pagina1 -> replaceFragmante(Pagina1(weatherResponse))

                                R.id.pagina2 -> { var contexto = applicationContext
                                    val intent = Intent(contexto, Mapa::class.java)
                                    startActivity(intent)
                                }
                                R.id.pagina3 -> { var contexto = applicationContext
                                    val intentSobre = Intent(contexto, Sobre::class.java)
                                    startActivity(intentSobre)
                                }

                                else -> {
                                    Toast.makeText(ctx, "Falha!", Toast.LENGTH_SHORT).show()
                                }
                            }
                            true
                        }
                    }
                } else {
                    Toast.makeText(ctx, "Resposta não bem-sucedida", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(ctx, "Falha na requisição", Toast.LENGTH_SHORT).show()
            }
            })
    }
}

