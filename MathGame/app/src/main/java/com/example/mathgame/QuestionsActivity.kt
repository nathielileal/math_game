package com.example.mathgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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
    var calc : Int = 0


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
        n2 = Random.nextInt(0, n1)
        operator = options.random()
        val equacao = findViewById<TextView>(R.id.equacaoView)
        equacao.text = "$n1 $operator $n2"
        calc = getOperator()


        }


    fun goNextActivity(view:View){
        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra("right",right)

        startActivity(intent)
    }

    fun next(view: View){
        if (tries < 5){
        val equacao = findViewById<TextView>(R.id.equacaoView)
        n1 = Random.nextInt(0, 99)
        n2 = Random.nextInt(0, n1)
        operator = options.random()
        equacao.text = "$n1 $operator $n2"
        calc = getOperator()
        var next = findViewById<Button>(R.id.buttonNext)
        next.visibility = View.INVISIBLE
        }else{
            goNextActivity(view)
        }

    }

    fun getOperator(): Int{

        if(operator == "+"){
            calc = n1 + n2
        }else{
            calc = n1 - n2
        }
        return calc
    }

    fun confirma(view : View){

        calc = getOperator()
        val resposta = findViewById<TextView>(R.id.editTextNumber)
        val colorLayout = findViewById<View>(R.id.main)
        val verdeSuave = Color.parseColor("#80A5D6A7") // verde claro pastel
        val vermelhoSuave = Color.parseColor("#80EF9A9A") // vermelho claro pastel
        if(calc == resposta.text.toString().toInt()) {
            colorLayout.setBackgroundColor(verdeSuave)
            right++
        }else{
            colorLayout.setBackgroundColor(vermelhoSuave)
        }
        tries++
        resposta.text = ""

        var next = findViewById<Button>(R.id.buttonNext)
        next.visibility = View.VISIBLE
    }
}





