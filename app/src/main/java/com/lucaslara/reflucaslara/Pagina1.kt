package com.lucaslara.reflucaslara

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.lucaslara.reflucaslara.bases.WeatherResponse

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [Pagina1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pagina1(weatherResponse: WeatherResponse?) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: WeatherResponse? = weatherResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pagina1, container, false)

        // Obter o texto passado como argumento
        val error = "Sem conexão"

        val probChuva = Array<String?>(7) { null }
        val dtChuva = Array<String?>(7) { null }
        val diaChuva = Array<String?>(7) { null }
        val description = Array<String?>(7) { null }

        param3?.results?.forecast?.let { forecast ->
            for (i in 0 until minOf(forecast.size, 7)) {
                probChuva[i] = "${forecast[i]?.rainProbability?.toString()}%"
                dtChuva[i] = forecast[i]?.date?.toString()
                diaChuva[i] = forecast[i]?.weekday?.toString()
                description[i] = forecast[i]?.description?.toString()
            }
        }

        //Definicao dos Text da tela
        val textViewCity = view.findViewById<TextView>(R.id.text_cidade)
        textViewCity.text = param3?.results?.city ?: error

        val textViewDes = view.findViewById<TextView>(R.id.text_estado)
        textViewDes.text = param3?.results?.description ?: error

        val textViewDate = view.findViewById<TextView>(R.id.text_data)
        textViewDate.text = param3?.results?.date ?: error

        val textViewHora = view.findViewById<TextView>(R.id.text_hora)
        textViewHora.text = param3?.results?.time ?: error

        val textViewtemp = view.findViewById<TextView>(R.id.text_temperatura)
        textViewtemp.text = "${param3?.results?.temp ?: error} " + "Graus"

        val textViewChuva = view.findViewById<TextView>(R.id.text_porcentagem)
        textViewChuva.text = "Hoje: ${probChuva[0]} - ${description[0]}" +
                            "\n${diaChuva[1]}: ${probChuva[1]} - ${description[1]}" +
                            "\n${diaChuva[2]}: ${probChuva[2]} - ${description[2]}" +
                            "\n${diaChuva[3]}: ${probChuva[3]} - ${description[3]}" +
                            "\n${diaChuva[4]}: ${probChuva[4]} - ${description[4]}" +
                            "\n${diaChuva[5]}: ${probChuva[5]} - ${description[5]}" +
                            "\n${diaChuva[6]}: ${probChuva[6]} - ${description[6]}" +
                            "\n \nSistema desenvolvido para estudos."
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pagina1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: WeatherResponse) =
            Pagina1(param3).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putSerializable(ARG_PARAM3, param3)
                }
            }
    }
}