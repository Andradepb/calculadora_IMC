package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.graphics.toColorInt

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val resultImc:Float =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val tvResult:TextView = findViewById(R.id.textView_result)
        val tvClassification = findViewById<TextView>(R.id.textView_Classification)

        tvResult.text = resultImc.toString()


        fun resultClassification (resultImc:Float):String {

            var classification = ""

            classification = when {
                resultImc < 18.5f -> "Abaixo do Peso"
                resultImc in 18.5f..24.9f -> "Peso Normal"
                resultImc in 25.0f..29.0f -> "Obesidade I"
                resultImc in 30.0f..39.9f -> "Obesidade II"
                else -> "Obesidade III"
            }
            return classification
        }

        // mostrando o resultado
        tvClassification.text = getString(
            R.string.message_classification,
            resultClassification(resultImc)
        )
    }
    // Criando outra função pra voltar para primeira página
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // fecha a tela atual
        finish()
        return super.onOptionsItemSelected(item)
    }
}