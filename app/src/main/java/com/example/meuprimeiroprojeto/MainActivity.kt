package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResult:Button = findViewById(R.id.btnCalculate)
        val editWeight: EditText = findViewById(R.id.edtWeight)
        val editHeight:EditText = findViewById(R.id.edtHeight)


        btnResult.setOnClickListener {
            // coloquei essa variavel porque quando o campo estava sem nada ele dava um crash
            val weightString = editWeight.text.toString()
            val heightString = editHeight.text.toString()
            // ja que estava acontecendo um crash eu coloquei esse if porque ele so vai executar
            //o código se não tiver vazio
            if (weightString.isNotEmpty() && heightString.isNotEmpty()){

            val weight = weightString.toFloat()
            val height = heightString.toFloat()

            val finalHeight: Float = height * height
            val imc: Float = weight / finalHeight

            // Levei o resultado para outra tela
            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", imc)
                }
            startActivity(intent)
        } else {
            // para aparecer a msg para preencher o campo
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }

        }

        }

   }
