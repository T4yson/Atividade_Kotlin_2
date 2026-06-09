package com.example.atividade_kotlin_2

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etRegiao = findViewById<EditText>(R.id.et_regiao)
        val etValorMercadoria = findViewById<EditText>(R.id.et_valor_mercadoria)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val tvPercentual = findViewById<TextView>(R.id.tv_percentual)
        val tvValorFrete = findViewById<TextView>(R.id.tv_valor_frete)
        val tvValorTotal = findViewById<TextView>(R.id.tv_valor_total)

        btnCalcular.setOnClickListener {
            val regiaoStr = etRegiao.text.toString().trim()
            val valorStr = etValorMercadoria.text.toString()

            if (regiaoStr.isEmpty() || valorStr.isEmpty()) {
                Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val valorMercadoria = valorStr.toDoubleOrNull() ?: 0.0

            val percentual = when (regiaoStr.lowercase()) {
                "sul" -> 0.05
                "sudeste" -> 0.07
                "centro-oeste", "centro oeste" -> 0.08
                "nordeste" -> 0.10
                "norte" -> 0.12
                else -> {
                    Toast.makeText(this, getString(R.string.error_regiao_invalida), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val valorFrete = valorMercadoria * percentual
            val valorTotal = valorMercadoria + valorFrete

            tvPercentual.text = getString(R.string.format_percentual, (percentual * 100).toInt())
            tvValorFrete.text = getString(R.string.format_valor_frete, valorFrete)
            tvValorTotal.text = getString(R.string.format_valor_total, valorTotal)

            // Esconder o teclado
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(btnCalcular.windowToken, 0)
        }
    }
}
