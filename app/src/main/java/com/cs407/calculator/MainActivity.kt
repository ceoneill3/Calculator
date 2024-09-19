package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val text1 = findViewById<EditText>(R.id.editTextText)
        val text2 = findViewById<EditText>(R.id.editTextText3)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val input1 = text1.text.toString().toInt()
            val input2 = text2.text.toString().toInt()

            val total = input1 + input2
            val result = "Result: $total"

            val intent = Intent(this, CalcDisplay::class.java)

            intent.putExtra("EXTRA_MESSAGE", result)

            startActivity(intent)


        }

        val subButton = findViewById<Button>(R.id.subButton)
        subButton.setOnClickListener {
            val input1 = text1.text.toString().toInt()
            val input2 = text2.text.toString().toInt()

            val total = input1 - input2
            val result = "Result: $total"

            val intent = Intent(this, CalcDisplay::class.java)

            intent.putExtra("EXTRA_MESSAGE", result)

            startActivity(intent)


        }

        val multButton = findViewById<Button>(R.id.multButton)
        multButton.setOnClickListener {
            val input1 = text1.text.toString().toInt()
            val input2 = text2.text.toString().toInt()

            val total = input1 * input2
            val result = "Result: $total"

            val intent = Intent(this, CalcDisplay::class.java)

            intent.putExtra("EXTRA_MESSAGE", result)

            startActivity(intent)


        }

        val divButton = findViewById<Button>(R.id.divideButton)
        divButton.setOnClickListener {
            try {
                val input1 = text1.text.toString().toInt()
                val input2 = text2.text.toString().toInt()

                val total = input1 / input2
                val result = "Result: $total"

                val intent = Intent(this, CalcDisplay::class.java)

                intent.putExtra("EXTRA_MESSAGE", result)

                startActivity(intent)
            } catch(e: ArithmeticException){
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
            }


        }


    }
}