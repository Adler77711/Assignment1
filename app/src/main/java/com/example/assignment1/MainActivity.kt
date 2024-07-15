package com.example.assignment1


import android.os.Bundle
import android.view.View
import android.widget.*
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
        val button: Button = findViewById(R.id.btConfirm)
        var language: String = "English"
        val resultTV: TextView = findViewById(R.id.tvResult)
        val spinnerLanguage : Spinner = findViewById(R.id.spLanguage)
        var options = arrayOf("English","French","Chinese")
        spinnerLanguage.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        button.setOnClickListener{ view ->
//code here
            when(language){
                "English" -> resultTV.text = "Hello World"
                "French" -> resultTV.text = "Bonjour à tous"
                "Chinese" -> resultTV.text = "你好世界"
            }
        }
        spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                language = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}

