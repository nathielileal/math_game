package com.example.mathgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.edit

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        calcularTotal(right)
    }

    fun recomecar(context: Context) {
        /* resetar as variaveis e limpar dados */
        var XXXXX = 0
        var YYYYY = ""
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit() { clear() }

        // volta pra MainActivity
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }


        fun calcularTotal(
            right: EditText,
            totalEditNumber: EditText
        ) {
            try {
                val valores = right;

                val total = valores.sumOf { it * 20 }

                totalEditNumber.setText(total.toString())

            } catch (e: Exception) {
                totalEditNumber.setText("Erro")
                e.printStackTrace()
            }
        }


    }






