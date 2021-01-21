package com.example.intenejer2;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    EditText jet,jet2;
    Bundle bdl;
    String num="",valA="",valB="",valC="";
    int i = 0;
    float A=0,B=0,C=0;
    float x1=0,x2=0;
    boolean imaginario;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.caja);
        jet2 = (EditText) findViewById(R.id.caja2);

        bdl = getIntent().getExtras();
        num = bdl.getString("NOMBRE");
        variables();
        A = Float.parseFloat(valA);
        B = Float.parseFloat(valB);
        C = Float.parseFloat(valC);
        imaginario=solucion();


        if(A==0){
            jet.append("Ecuacion no es de segundo grado");
            float resultado1 = C/B;
            resultado1 = resultado1*(-1);
            jet2.append("Raíz única: "+resultado1);
        }
        else{
            if(imaginario==false){
                jet.append("x1 = " + x1 + "+ i");
                jet2.append("x2 = " + x2 + "+ i");
            }
            else{
                jet.append("x1 = " + x1);
                jet2.append("x2 = " + x2);
            }
        }
    }

    public boolean solucion(){
        float cuadrado=0,resta=0;
        float raiz=0;

        cuadrado = (int)Math.pow(B,2);
        resta = cuadrado - (4*A*C);

        if(resta < 0){
            raiz = (float)Math.sqrt(resta*-1);
            x1 = (((-1*B) + raiz)/(2*A));
            x2 = (((-1*B) - raiz)/(2*A));
            return false;
        }
        else{
            raiz = (float)Math.sqrt(resta);
            x1 = (((-1*B) + raiz)/(2*A));
            x2 = (((-1*B) - raiz)/(2*A));
            return true;
        }

    }



    public void variables(){
        for (i=0; i < num.length(); i++){
            char caracter = num.charAt(i);
            if(caracter != '*'){
                valA = valA + caracter;
            }
            else{
                break;
            }
        }

        for(i=i+1; i < num.length(); i++){
            char caracter = num.charAt(i);
            if(caracter != '+'){
                valB = valB + caracter;
            }
            else{
                break;
            }

        }

        for(i=i+1; i < num.length(); i++){
            char caracter = num.charAt(i);
            valC = valC + caracter;
        }
    }
}