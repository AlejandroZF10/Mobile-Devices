package com.example.intenejer2;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;
public class MainActivity extends Activity{
    EditText gA,gB,gC;
    Button bAccion;
    Bundle bdl;
    Intent itn;
    String persona="";
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        gA = (EditText) findViewById(R.id.valorA);
        gB = (EditText) findViewById(R.id.valorB);
        gC = (EditText) findViewById(R.id.valorC);

        bAccion = (Button) findViewById(R.id.Accion);
        bAccion.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                persona= gA.getText().toString() + "*" + gB.getText().toString()
                        +"+"+gC.getText().toString();
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("NOMBRE",persona);
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}
