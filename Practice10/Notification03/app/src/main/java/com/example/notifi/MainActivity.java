package com.example.notifi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.*;
import android.content.*;
import android.graphics.drawable.BitmapDrawable;
import androidx.core.app.NotificationCompat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity {
    int t=200, i=2, ban=0;
    boolean c=true;
    TextView jtv;
    Button jbnN;
    SQLiteDatabase sqld;
    private static final int NOTIF_ALERTA_ID = 1;


    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        jtv = (TextView) findViewById(R.id.xtv);
        jbnN = (Button)findViewById(R.id.xbnN);



        sqld = dsqlh.getWritableDatabase();

        int temp=0,aux=0;
        Cursor c = sqld.rawQuery("SELECT id FROM Contactos", null);
        if(c.moveToFirst()){
            do{
                temp=Integer.parseInt(c.getString(0));
                aux=temp;
            }while(c.moveToNext());
        }

        ContentValues cv = new ContentValues();
        aux=aux-1;
        cv.put("id",aux);
        sqld.update("Contactos",cv,"id="+temp,null);

        if(aux!=0){
            NotificationCompat.Builder ncb =
                    new NotificationCompat.Builder(MainActivity.this)
                            .setSmallIcon(android.R.drawable.stat_sys_warning)
                            .setLargeIcon((((BitmapDrawable) getResources()
                                    .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                            .setContentTitle("Alerta de Notificación")
                            .setContentText("Uso de la notificación." + "i=" + aux)
                            .setContentInfo("Un valor")
                            .setTicker("Mensaje de Alerta!");
            Intent in = new Intent(MainActivity.this, MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,in,0);
            ncb.setContentIntent(pi);
            NotificationManager nm = (NotificationManager) getSystemService(
                    Context.NOTIFICATION_SERVICE);
            nm.notify(NOTIF_ALERTA_ID, ncb.build());
        }

        jbnN.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                    int temp=0,aux=0;
                    Cursor c = sqld.rawQuery("SELECT id FROM Contactos", null);
                    if(c.moveToFirst()){
                        do{
                            temp=Integer.parseInt(c.getString(0));
                            aux=temp;
                        }while(c.moveToNext());
                    }

                    ContentValues cv = new ContentValues();
                    aux=aux+1;
                    cv.put("id",aux);
                    sqld.update("Contactos",cv,"id="+temp,null);


                    System.out.println("Entra al if");
                    NotificationCompat.Builder ncb =
                            new NotificationCompat.Builder(MainActivity.this)
                                    .setSmallIcon(android.R.drawable.stat_sys_warning)
                                    .setLargeIcon((((BitmapDrawable) getResources()
                                            .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                                    .setContentTitle("Alerta de Notificación")
                                    .setContentText("Uso de la notificación." + "i=" + aux)
                                    .setContentInfo("Un valor")
                                    .setTicker("Mensaje de Alerta!");
                    Intent in = new Intent(MainActivity.this, MainActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,in,0);
                    ncb.setContentIntent(pi);
                    NotificationManager nm = (NotificationManager) getSystemService(
                            Context.NOTIFICATION_SERVICE);
                    nm.notify(NOTIF_ALERTA_ID, ncb.build());

                jtv.setText("Cuenta: i=" +aux);
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */
}