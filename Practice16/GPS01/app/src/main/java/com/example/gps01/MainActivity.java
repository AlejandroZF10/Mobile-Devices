package com.example.gps01;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends FragmentActivity {
    Button btnActualizar;
    EditText latitud,longitud,precision,power;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitud = (EditText) findViewById(R.id.xetlatitud);
        longitud = (EditText) findViewById(R.id.xetlongitud);
        precision = (EditText) findViewById(R.id.xetprecision);
        power = (EditText) findViewById(R.id.xetpower);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localization();
                list_Providers();
            }
        });
    }

    private void localization() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 1000);
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(locationManager != null){
            latitud.setText("Latitud: "+location.getLatitude());
            longitud.setText("Longitud: "+location.getLongitude());
        }else{
            latitud.setText("Latitud: (sin datos)");
            longitud.setText("Longitud: (sin datos)");
        }
    }

    private void list_Providers(){
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> lista_provider = locationManager.getAllProviders();
        LocationProvider provider = locationManager.getProvider(lista_provider.get(0));
        precision.setText("Precision: "+provider.getAccuracy());
        switch(provider.getPowerRequirement()){
            case 0:
                power.setText("Power Requirement: Passive");
                break;
            case 1:
                power.setText("Power Requirement: GPS");
                break;
            case 2:
                power.setText("Power Requirement: NETWORK");
                break;
        }
    }
}