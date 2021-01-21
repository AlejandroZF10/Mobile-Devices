package com.example.intenejer1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;
public class MainActivity extends Activity{
    EditText gNombre,gApellido;
    Button bAccion;
    Bundle bdl;
    Intent itn;
    String persona="";
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        gNombre = (EditText) findViewById(R.id.Nombre);
        gApellido = (EditText) findViewById(R.id.Apellido);

        bAccion = (Button) findViewById(R.id.Accion);
        bAccion.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                persona= gNombre.getText().toString() + " " + gApellido.getText().toString();
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("NOMBRE",persona);
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}
