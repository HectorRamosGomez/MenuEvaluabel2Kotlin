package com.example.menuevaluable2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menuevaluable2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var dadoNumero = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonGirar.setOnClickListener {
            dadoNumero = generarNumeroRandom()
            binding.textoInstrucciones.text = dadoNumero.toString()
            asignarFoto(dadoNumero)

        }

    }

    private fun generarNumeroRandom(): Int {
        return (1..6).random()
    }

    private fun asignarFoto(dadoNumero: Int) {
        var fotos = when(dadoNumero) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.foto.setImageResource(fotos)
    }
}