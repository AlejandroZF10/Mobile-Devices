package com.example.maravilloso;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

public class MainActivity extends Activity{
    private EditText edt1,edt2;
    private TextView txtv1,txtv2,txtv3,txtv4;
    private Button btn1;
    @Override

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.plain_text_input1);
        edt2 = (EditText)findViewById(R.id.plain_text_input2);
        txtv1 = (TextView)findViewById(R.id.textView1);
        txtv2 = (TextView)findViewById(R.id.textView2);
        txtv3 = (TextView)findViewById(R.id.textView3);
        txtv4 = (TextView)findViewById(R.id.textView4);
        btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto1;
                texto1 =  edt1.getText().toString();
                int numero = Integer.parseInt(texto1);
                txtv1.setText(numero_maravilloso(numero,texto1));
                txtv2.setText(getPrime(numero,texto1));
                txtv3.setText(fibonacci(numero,texto1));
                if (!palindromo(edt2.getText().toString()))
                    txtv4.setText("Palindromo");
                else
                    txtv4.setText("NO es palindromo");
            }
        });
    }
    public String numero_maravilloso(int n, String s){
        s +="\n"+ n + ",";
        if (n == 1) {
            s = s + "\nEs un nùmero maravilloso\n";
            return s;
        }
        if (n % 2 == 0)
            return this.numero_maravilloso(n / 2, s);
        return this.numero_maravilloso(n * 3 + 1, s);
    }
    public String getPrime(int n, String s) {
        int contador = 2;
        int bandera = 1;
        while (contador != n) {
            if (n % contador == 0)
                bandera = 0;
            contador++;
        }
        if (bandera == 0)
            return s = "No es primo\n";
        else
            return s = "Es primo\n";
    }
    public String fibonacci(int n, String s) {
        int numero = 100;
        int f = 0;
        int t1 = 1;
        int t2;
        int bandera = 0;

        for (int i = 1; i <= numero; i++) {
            t2 = f;
            f = t1 + f;
            t1 = t2;
            if (t1 == n)
                bandera = 1;
        }
        if (bandera == 1)
            return s = "Es Fibonacci\n";
        else
            return s = "No es Fibonacci\n";
    }
    public boolean palindromo(String cadena){
        int inc = 0;
        int des = cadena.length()-1;
        boolean bError = false;
        while ((inc<des) && (!bError)){
            if (cadena.charAt(inc)==cadena.charAt(des)){
                inc++;
                des--;
            } else {
                bError = true;
            }
        }
        return bError;
    }
}