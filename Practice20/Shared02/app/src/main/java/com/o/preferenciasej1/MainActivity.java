package com.o.preferenciasej1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.*;
import android.app.*;
import android.view.View;
import android.widget.*;
public class MainActivity extends Activity{
    SharedPreferences sp;
    EditText nombre, apellido;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        findViewById(R.id.buttonGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putString("nombre", nombre.getText().toString());
                miEditor.putString("apellido",apellido.getText().toString());
                Toast.makeText(MainActivity.this,"Guardado",Toast.LENGTH_LONG).show();
                miEditor.commit();
            }
        });
        findViewById(R.id.buttonVer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ActivityVer.class);
                startActivity(i);
            }
        });
    }

}
