package com.tonight.tonight.gui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tonight.tonight.infra.GuiUtil;
import com.tonight.tonight.R;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int valor = 0;
    GuiUtil guiUtil = GuiUtil.getGuiUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        String valorIntent = intent.getExtras().getString("VALOR");
        if(Objects.equals(valorIntent, "Rock")){
            valor = 1;
        } else if(Objects.equals(valorIntent, "Dremelgas")) {
            valor = 2;
        } else {
            valor = 0;
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(valor == 1) {
            LatLng recife = new LatLng(-8.047562, -34.876964);
            LatLng recife2 = new LatLng(-8.047324,-34.8776972);
            LatLng recife3 = new LatLng(-8.047884,-34.8779012);
            LatLng recife4 = new LatLng(-8.047135,-34.8771372);
            mMap.addMarker(new MarkerOptions().position(recife).title("Show de Rock").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mMap.addMarker(new MarkerOptions().position(recife2).title("Rock Festival").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            mMap.addMarker(new MarkerOptions().position(recife3).title("Metalhead").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            mMap.addMarker(new MarkerOptions().position(recife4).title("U2 Cover").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            float zoomLevel = (float) 17.0;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife, zoomLevel));
        } else if(valor == 2){
            LatLng recife2 = new LatLng(-8.047, -34.876);
            mMap.addMarker(new MarkerOptions().position(recife2).title("Recital de poesia Dremelgas"));
            float zoomLevel = (float) 17.0;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife2, zoomLevel));
        } else {
            LatLng recife2 = new LatLng(-8.047, -34.87613);
            mMap.addMarker(new MarkerOptions().position(recife2).title("Peça de Teatro Elefante"));
            float zoomLevel = (float) 17.0;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife2, zoomLevel));
        }


    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.botaoPesquisar) {
            Intent intent = new Intent(getApplicationContext(), SearchEventActivity.class);
            startActivity(intent);
        } else if(v.getId() == R.id.botaoCriar) {
            Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
            startActivity(intent);
        }
    }
}
