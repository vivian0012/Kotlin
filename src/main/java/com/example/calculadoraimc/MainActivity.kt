package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var textInputLayout1: TextInputLayout
    private lateinit var textInputLayout2: TextInputLayout
    private lateinit var altura: TextInputEditText;
    private lateinit var peso: TextInputEditText;
    private lateinit var calcular: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        atributos()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {

        calcular.setOnClickListener() {
            altura.error = null
            peso.error = null

            val intent = Intent(this, ResultadoFromMain::class.java)
            val resultadoAltuda = altura.text.toString()
            val resultadoPeso = peso.text.toString()

            if (resultadoAltuda.isEmpty()) {
                textInputLayout1.error = "Digite um valor válido."

            } else if (resultadoPeso.isEmpty()) {
                textInputLayout2.error = "Digite um valor válido."
            } else {

                val resultadoTwo =  resultadoPeso.toDouble()/ (resultadoAltuda.toDouble() * resultadoAltuda.toDouble())
                val formatResultado = round(resultadoTwo * 100) / 100
                intent.putExtra("ResultIMC", formatResultado)
                startActivity(intent)
            }
        }
        super.onStart()
    }

    private fun atributos() {
        textInputLayout1 = findViewById(R.id.textInputAltura);
        textInputLayout2 = findViewById(R.id.textInputPeso)
        altura = findViewById(R.id.Altura);
        peso = findViewById(R.id.Peso);
        calcular = findViewById(R.id.Calcular);
    }
}

