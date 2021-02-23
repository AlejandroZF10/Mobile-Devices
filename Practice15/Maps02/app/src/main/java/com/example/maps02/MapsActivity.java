package com.example.maps02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private Button btnOpciones,btnMover,btnAnimar,btnPosicion;
    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;
        btnOpciones = (Button)findViewById(R.id.btnSatelite);
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarOpciones();
            }
        });

        btnMover = (Button)findViewById(R.id.btnMover);
        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moverMadrid();
            }
        });

        btnAnimar = (Button)findViewById(R.id.btnAnimar);
        btnAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animarMadrid();
            }
        });

        btnPosicion = (Button)findViewById(R.id.btnPosicion);
        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerPosicion();
            }
        });

        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng point) {
                Projection proj = mapa.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(
                        MapsActivity.this,
                        "Click\n" +
                                "Lat: " + point.latitude + "\n" +
                                "Lng: " + point.longitude + "\n" +
                                "X: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void cambiarOpciones(){
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
    }
    private void moverMadrid(){
        LatLng madrid = new LatLng(19.4284700, -99.1276600);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(madrid, 5);
        mapa.addMarker(new MarkerOptions().position(madrid).title("Marker in Madrid"));
        mapa.moveCamera(camUpd1);
    }
    private void animarMadrid(){
        LatLng madrid = new LatLng(19.4284700, -99.1276600);
        CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)   //Centramos el mapa en Madrid
                .zoom(19)         //Establecemos el zoom en 19
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .build();
        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
        mapa.animateCamera(camUpd3);
    }
    private void obtenerPosicion()    {
        CameraPosition camPos = mapa.getCameraPosition();
        LatLng coordenadas = camPos.target;
        double latitud = coordenadas.latitude;
        double longitud = coordenadas.longitude;
        Toast.makeText(this, "Lat: " + latitud + " | Long: " + longitud, Toast.LENGTH_SHORT).show();
    }
}