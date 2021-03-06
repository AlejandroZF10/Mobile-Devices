package com.example.practice03_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Declaracion de los botones de numeros
    Button btUno,btDos,btTres,btCuatro,btCinco,btSeis,btSiete,btOcho,btNueve,btCero;
    //Declaracion de los botones de operaciones
    Button btnSuma,btnResta,btnMultiplica,btnDivide,btnClean,btnBorrar,btnPunto,btnFact,btnIgual;
    //Declaracion del textview donde se mostraran los resultados
    TextView Resultado;
    //Declaracion de variables
    double resultado;
    String operador,mostrar,reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Botones de Numeros
        btUno = (Button)findViewById(R.id.Uno);
        btDos = (Button)findViewById(R.id.Dos);
        btTres = (Button)findViewById(R.id.Tres);
        btCuatro = (Button)findViewById(R.id.Cuatro);
        btCinco = (Button)findViewById(R.id.Cinco);
        btSeis = (Button)findViewById(R.id.Seis);
        btSiete = (Button)findViewById(R.id.Siete);
        btOcho = (Button)findViewById(R.id.Ocho);
        btNueve = (Button)findViewById(R.id.Nueve);
        btCero = (Button)findViewById(R.id.Cero);
//Botones de Operaciones
        btnSuma = (Button)findViewById(R.id.Suma);
        btnResta = (Button)findViewById(R.id.Resta);
        btnMultiplica = (Button)findViewById(R.id.Multiplica);
        btnDivide = (Button)findViewById(R.id.Divide);
        btnClean = (Button)findViewById(R.id.Clean);
        btnBorrar = (Button)findViewById(R.id.Borrar);
        btnPunto = (Button)findViewById(R.id.Punto);
        btnIgual = (Button)findViewById(R.id.Igual);
        btnFact = (Button)findViewById(R.id.Factorial);
//TextView de resultados
        Resultado = (TextView)findViewById(R.id.Etiqueta);
//Oyentes de acción para darles funcionamiento a los botones
        //Accion Boton del numero 0
        btCero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "0";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 1
        btUno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 2
        btDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "2";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 3
        btTres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "3";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 4
        btCuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "4";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 5
        btCinco.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "5";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 6
        btSeis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "6";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 7
        btSiete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "7";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 8
        btOcho.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "8";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del numero 9
        btNueve.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "9";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton de la suma
        btnSuma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "+";
                Resultado.setText("");
            }
        });
        //Accion Boton de la resta
        btnResta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "-";
                Resultado.setText("");
            }
        });
        //Accion Boton de la multiplicación
        btnMultiplica.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "*";
                Resultado.setText("");
            }
        });
        //Accion Boton de la división
        btnDivide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "/";
                Resultado.setText("");
            }
        });
        //Accion Boton de Factorial
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reserva = Resultado.getText().toString();
                long factorial = 1;
                for(int i = 1; i <= Integer.parseInt(reserva); i++)
                    factorial = factorial * i;
                String result = String.valueOf(factorial);
                Resultado.setText(result);
            }
        });
        //Accion Boton del punto
        btnPunto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + ".";
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton del limpiar
        btnClean.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = "";
                Resultado.setText(mostrar);
                reserva = "";
                operador = "";
            }
        });
        //Accion Boton de borrar
        btnBorrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar.substring(0,mostrar.length()-1);
                Resultado.setText(mostrar);
            }
        });
        //Accion Boton de igual
        btnIgual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                if(operador.equals("-")){
                    resultado = Double.parseDouble(reserva) - Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("/")){
                    resultado = Double.parseDouble(reserva) / Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("*")){
                    resultado = Double.parseDouble(reserva) * Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("+")){
                    resultado = Double.parseDouble(reserva) + Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
            }
        });

    }
}
