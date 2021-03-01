package com.o.preferenciasej2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.*;
import android.app.*;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity{
    SharedPreferences sp;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        findViewById(R.id.buttonGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i,109);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 109){
            Uri image = data.getData();
            SharedPreferences.Editor miEditor = sp.edit();
            miEditor.putString("imagen",image.toString());
            Toast.makeText(MainActivity.this,"Guardado",Toast.LENGTH_LONG).show();
            miEditor.commit();
        }
    }

}
