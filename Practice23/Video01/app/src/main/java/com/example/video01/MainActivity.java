package com.example.video01;

import android.app.*;
import android.net.*;
import android.os.*;
import android.widget.*;
public class MainActivity extends Activity {
    VideoView	vvw;
    Uri		uri;
    MediaController mcr;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        vvw = (VideoView) findViewById(R.id.xvv1);
        uri = Uri.parse("android.resource://com.example.video01/"+R.raw.harina);
        mcr = new MediaController(this);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(uri);
        vvw.start();
    }
}
