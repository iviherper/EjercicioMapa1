package com.example.ejerciciomapa1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {
    Spinner spinner;
    Button boton;
    private GoogleMap mMap;
    ArrayList<Ciudad> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        boton = findViewById(R.id.button);
        ciudades =crearCiudades();
        List<String>nombres = new ArrayList<>();
        for (Ciudad c:ciudades
             ) {
            nombres.add(c.getNombre());
        }
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, nombres));
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        boton.setOnClickListener(this::onClick);
    }

    private ArrayList<Ciudad> crearCiudades() {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad madrid = new Ciudad("Madrid",40.423382, -3.712165);
        Ciudad bilbao = new Ciudad("Bilbao",43.266953,-2.938022);
        Ciudad sevilla = new Ciudad("Sevilla", 37.377197,-5.986893);
        ciudades.add(madrid);
        ciudades.add(bilbao);
        ciudades.add(sevilla);
        return ciudades;
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v) {
        int opcion = spinner.getSelectedItemPosition();
        Ciudad c = ciudades.get(opcion);
        cambiarMapa(c);
    }

    private void cambiarMapa(Ciudad c) {
        mMap.clear();
        LatLng ciudad = new LatLng(c.getLat(), c.getLng());
        mMap.addMarker(new MarkerOptions().position(ciudad).title("Marker in "+c.getNombre()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
    }
}