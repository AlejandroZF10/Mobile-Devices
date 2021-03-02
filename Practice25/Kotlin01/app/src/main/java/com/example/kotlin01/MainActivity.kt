package com.example.kotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularEcuacion(v: View) {

        val x1: Double
        val x2: Double

        val sCoeficienteA = findViewById<View>(R.id.txtCoeficienteA) as EditText
        val sCoeficienteB = findViewById<View>(R.id.txtCoeficienteB) as EditText
        val sCoeficienteC = findViewById<View>(R.id.txtCoeficienteC) as EditText
        val sResultado = findViewById<View>(R.id.lblResultado) as TextView

        val a = java.lang.Float.parseFloat(sCoeficienteA.text.toString())
        val b = java.lang.Float.parseFloat(sCoeficienteB.text.toString())
        val c = java.lang.Float.parseFloat(sCoeficienteC.text.toString())

        var d = b * b - 4f * a * c
        if (a == 0f) {
            var resultado1 = c / b
            resultado1 = resultado1 * -1
            sResultado.text = "La ecuacion no es de segundo grado\nRaíz única: $resultado1"
        } else {
            if (d < 0) {
                d = d * -1
                x1 = (-b + Math.sqrt(d.toDouble())) / (2 * a)
                x2 = (-b - Math.sqrt(d.toDouble())) / (2 * a)
                sResultado.text = "No existen soluciones reales\nx1 = $x1+i\nx2 = $x2+i"
            } else {
                x1 = (-b + Math.sqrt(d.toDouble())) / (2 * a)
                x2 = (-b - Math.sqrt(d.toDouble())) / (2 * a)
                sResultado.text = "Solución X1: $x1\n Solución X2: $x2"
            }
        }

    }

}
