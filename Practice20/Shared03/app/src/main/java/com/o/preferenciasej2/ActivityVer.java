package com.o.preferenciasej2;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ActivityVer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        SharedPreferences sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        Uri image = Uri.parse(sp.getString("imagen",""));
        InputStream is;
        try {
            is = getContentResolver().openInputStream(image);
            BufferedInputStream bis = new BufferedInputStream(is);
            Bitmap bitmap = BitmapFactory.decodeStream(bis);
            ImageView iv = (ImageView)findViewById(R.id.imageVer);
            iv.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {}
    }
}
