package com.example.mathgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class QuestionsActivity : AppCompatActivity() {

    private var tries = 0
    private var right = 0
    val options = listOf<String>( "+", "-")
    var n1 : Int = 0
    var n2 : Int =  0
    var operator = ""
//
//    val bttnAnswer = findViewById<Button>(R.id.buttonAnswer)
//    val bttnNext = findViewById<Button>(R.id.buttonNext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        n1 = Random.nextInt(0, 99)
        n2 = Random.nextInt(0, 99)
        operator = options.random()
        val equacao = findViewById<TextView>(R.id.equacaoView)
        equacao.text = "$n1 $operator $n2"

//        val eq2 = findViewById<TextView>(R.id.equacaoView2)
//        eq2.text = "aaa"
        }

    fun next(view: View){
        val equacao = findViewById<TextView>(R.id.equacaoView)
        n1 = Random.nextInt(0, 99)
        n2 = Random.nextInt(0, 99)
        operator = options.random()
        equacao.text = "$n1 + $n2"
    }
//
    fun getOperator(view: View): Int{
        var calc : Int = 0
        if(operator == "+"){
            calc = n1 + n2
        }else{
            calc = n1 - n2
        }
        return calc
    }

//
//    fun confirma(view: View){
//
//        val calc : Int = getOperator(view)
//        val resposta = findViewById<TextView>(R.id.editTextNumber)
//
//        if(calc == resposta.text.toString().toInt()) {
//            right++
//        }
//        tries++
//        resposta.text = ""
//    }
}





