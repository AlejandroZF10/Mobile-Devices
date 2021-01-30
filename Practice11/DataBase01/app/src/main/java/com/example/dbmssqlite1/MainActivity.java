package com.example.dbmssqlite1;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.AlertDialog;

public class MainActivity extends Activity {
    EditText jetI, jetN, jetNew;
    Button jbnA, jbnL, jbnD, jbnC;
    TextView jtvL;
    SQLiteDatabase sqld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText) findViewById(R.id.xetI);
        jetN = (EditText) findViewById(R.id.xetN);
        jetNew = (EditText) findViewById(R.id.xetII);
        jbnA = (Button) findViewById(R.id.xbnA);
        jbnL = (Button) findViewById(R.id.xbnL);
        jbnD = (Button)findViewById(R.id.xbnD);
        jbnC = (Button)findViewById(R.id.xbnC);
        jtvL = (TextView) findViewById(R.id.xtvL);
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int cont = 0, flag = 0;
                int id = Integer.parseInt(jetI.getText().toString());
                String nombre = jetN.getText().toString();
                int id_aux[] = new int[10];
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
                if (c.moveToFirst()) {
                    do {
                        id_aux[cont] = Integer.parseInt(c.getString(0));
                        cont++;
                    } while(c.moveToNext());
                }
                for(int i=0; i<id_aux.length ;i++){
                    if(id_aux[i] == id){
                        Toast.makeText(MainActivity.this,"Ya existe ese archivo", Toast.LENGTH_SHORT).show();
                        flag = 0;
                        break;
                    }
                    else{
                        flag = 1;
                    }
                }
                if(flag==1){
                    ContentValues cv = new ContentValues();
                    cv.put("id", id);
                    cv.put("nombre", nombre);
                    sqld.insert("Contactos", null, cv);
                    jetI.setText(""); jetN.setText("");
                }
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0);
                        nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });
        jbnD.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id = jetI.getText().toString();
                sqld.delete("Contactos", "id="+id, null);
                jetI.setText(""); jetN.setText("");
            }
        });
        jbnC.setOnClickListener(new OnClickListener() {
            int cont = 0, flag = 0;
            public void onClick(View view) {
                int id = Integer.parseInt(jetI.getText().toString());
                int id2 = Integer.parseInt(jetNew.getText().toString());
                String nombre = jetN.getText().toString();
                if(id2 == 0){
                    ContentValues cv = new ContentValues();
                    cv.put("nombre", nombre);
                    sqld.update("Contactos", cv, "id="+id, null);
                }else{
                    ContentValues cv = new ContentValues();
                    cv.put("id",id2);
                    cv.put("nombre", nombre);
                    sqld.update("Contactos", cv, "id="+id, null);
                }
            }
        });
    }
}