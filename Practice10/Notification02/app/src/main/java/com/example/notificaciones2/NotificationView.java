package com.example.notificaciones2;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class NotificationView extends Activity {
    int id = 1;
    int cont = 13;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.notificacion);
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
    }
    public void onClick(View v){
        displayNotification();
    }
    protected void displayNotification(){
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", id);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        CharSequence ticker = "Nueva entrada en ESCOM";
        CharSequence contentTitle = "Notificaciones";
        CharSequence contentText = "Curso de Android";
        Notification noti = new NotificationCompat.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Uso de la notificación." + "i=" + --cont)
                .addAction(R.mipmap.ic_launcher, ticker, pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(id, noti);
    }
}
