package com.lucaslara.reflucaslara

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private val splashTimeout = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Handler para atrasar a transição para a próxima activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java) // Substitua MainActivity pela sua atividade principal
            startActivity(intent)
            finish()
        }, splashTimeout.toLong())
    }
}