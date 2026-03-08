package com.example.menuevaluable2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.menuevaluable2.databinding.ActivityMainBinding

class DadosActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var dadoNumero = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




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