package com.example.menuevaluable2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.menuevaluable2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // 1. Registro para recibir la foto de la cámara
    private val respuestaCamara = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            // Obtenemos la miniatura de la foto
            val imagenBitmap = data?.extras?.get("data") as Bitmap
            binding.ImagenDNI.setImageBitmap(imagenBitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 2. Inflar el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Configurar botón para abrir la cámara
        binding.BotonFoto.setOnClickListener {
            val intentCamara = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                respuestaCamara.launch(intentCamara)
            } catch (e: Exception) {
                Toast.makeText(this, "No se pudo abrir la cámara", Toast.LENGTH_SHORT).show()
            }
        }

        // 4. Configurar botón para enviar/compartir datos
        binding.BotonEnviar.setOnClickListener {
            enviarDatos()
        }
    }

    private fun enviarDatos() {
        val nombre = binding.EditNombre.text.toString()
        val apellidos = binding.EditApellidos.text.toString()
        val correo = binding.EditCorreo.text.toString()
        val telefono = binding.EditTelefono.text.toString()
        val dni = binding.EditDNI.text.toString()

        // Validación básica
        if (nombre.isEmpty() || correo.isEmpty() || dni.isEmpty()) {
            Toast.makeText(this, "Por favor, rellena los campos obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        val resumen = """
            Registro de usuario:
            - Nombre: $nombre $apellidos
            - Correo: $correo
            - Teléfono: $telefono
            - DNI: $dni
        """.trimIndent()

        // Intent implícito para compartir texto
        val intentCompartir = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Registro de usuario")
            putExtra(Intent.EXTRA_TEXT, resumen)
        }

        // Selector de aplicaciones
        val chooser = Intent.createChooser(intentCompartir, "Compartir registro vía...")
        startActivity(chooser)
    }
}