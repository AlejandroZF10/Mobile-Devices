package com.o.preferenciasej1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityVer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        SharedPreferences sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        ((TextView) findViewById(R.id.textViewNombreVer)).setText(sp.getString("nombre","No disponible"));
        ((TextView) findViewById(R.id.textViewApellidoVer)).setText(sp.getString("apellido","No disponible"));
    }
}
