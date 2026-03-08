package com.example.menuevaluable2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.menuevaluable2.databinding.ActivityMainBinding

class DadosActivity : AppCompatActivity() {

    // 1. Declaramos el binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. IMPORTANTE: Inicializar el binding antes de usarlo
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ahora ya puedes usar los IDs del XML sin que la app se cierre
        binding.botonGirar.setOnClickListener {
            val numero = (1..6).random()
            binding.textoInstrucciones.text = numero.toString()

            val fotoRes = when(numero) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            binding.foto.setImageResource(fotoRes)
        }
    }
}

