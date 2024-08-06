package com.example.calculadoraimc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoFromMain : AppCompatActivity() {
    private lateinit var result: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_resultado_from_main)
        atributos()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun atributos() {
        result = findViewById(R.id.Resultado)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        val mostrarResultado = bundle?.getDouble("ResultIMC")

        if (mostrarResultado != null) {
            if (mostrarResultado < 18.5) {
                result.text = "O seu peso é de $mostrarResultado KG. Você está abaixo do peso."

            } else if( (mostrarResultado == 18.5) || (mostrarResultado <= 24.9)) {
                result.text = "O seu peso é de $mostrarResultado KG. Você está normal."

            } else if ( mostrarResultado >= 24.9 || mostrarResultado <= 29.9) {
                result.text = "O seu peso é de $mostrarResultado KG. Você está sobre peso."

            } else {
                if ((mostrarResultado >= 30.9) || (mostrarResultado <= 39.9)) {
                    result.text = "O seu peso é de $mostrarResultado KG. Você está sobre peso."
                } else {
                    result.text = "Tente novamente"
                }
            }

        }
}
}
