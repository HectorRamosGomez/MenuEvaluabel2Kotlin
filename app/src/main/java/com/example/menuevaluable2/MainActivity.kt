package com.example.menuevaluable2

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menuevaluable2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primera_pantalla)

        val botonDado = findViewById<Button>(R.id.BotonDados)

        botonDado.setOnClickListener {
            val intent = Intent(this, DadosActivity::class.java)
            startActivity(intent)
        }

        val botonLogin = findViewById<Button>(R.id.BotonLogin)
        botonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}