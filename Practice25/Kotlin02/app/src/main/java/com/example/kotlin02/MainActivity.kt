package com.example.kotlin02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Operador de llamada segura
        val string: String? = "Hello World!"
        print(string?.length)  // Will print the string's length, or "null" if the string is null.

        //Operador Elvis
        var a: String? = "Nullable String Value"
        val b = a?.length ?: -1

        //Operador !!
        //val x: Int? = null
        //val y = x!!.toDouble()

        //Expresión lambada
        btn1.setOnClickListener {view -> Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show() }

        //Funciones de extenseión
        var multiplicacion = 20.multiplicar(5)
        println("El resultado de la multiplicacion es $multiplicacion == ${20.times(5)}")


    }
    fun Int.multiplicar(numero: Int): Int {
        return this * numero
    }
}
