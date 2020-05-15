package com.example.dailygym.ui.cardio;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.dailygym.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marcador;
    double lat = 0.0;
    double longi=0.0;
    double lat2 = 0.0;
    double longi2=0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
        PolylineOptions lineOptions = null;
        ArrayList<LatLng> points = null;
        //miUbicacion();

        /*if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }*/
        //mMap.setMyLocationEnabled(true);
        //mMap.getUiSettings().setMyLocationButtonEnabled(true);
        // Add a marker in Sydney and move the camera
         lat= CrearRuta.getLatitudInicial();
         longi= CrearRuta.getLongitudInicial();
         lat2= CrearRuta.getLatitudFinal();
         longi2= CrearRuta.getLongitudFinal();



        LatLng origen = new LatLng(lat, longi);
        LatLng destino= new LatLng(lat2,longi2);

        points = new ArrayList<LatLng>();
        lineOptions = new PolylineOptions();
        points.add(origen);
        points.add(destino);
        // Agregamos todos los puntos en la ruta al objeto LineOptions
        lineOptions.addAll(points);
        //Definimos el grosor de las Polilíneas
        lineOptions.width(4);
        //Definimos el color de la Polilíneas
        lineOptions.color(Color.BLUE);

        mMap.addPolyline(lineOptions);
        mMap.addMarker(new MarkerOptions().position(origen).title("Origen").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
       mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen, 11));

        mMap.addMarker(new MarkerOptions().position(destino).title("Destino").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


       /* LatLng origen = new LatLng(, longi);
        mMap.addMarker(new MarkerOptions().position(origen).title("Logroño").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng destino = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(destino).title("Logroño").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(logr, 13));*/

       // mMap.addMarker(new MarkerOptions().position(logr).title("Mi ubicacion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
       // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(logr, 13));
    }
    private void agregarMarcador(double lat,double longi){
        LatLng coordenadas= new LatLng(lat,longi);
        CameraUpdate miub=CameraUpdateFactory.newLatLngZoom(coordenadas,13) ;
        if(marcador!=null)marcador.remove();
        marcador=mMap.addMarker(new MarkerOptions().position(coordenadas).title("Mi ubicacion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(miub);
    }

    private void actUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            longi = location.getLongitude();
            agregarMarcador(lat,longi);
        }
    }



    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actUbicacion(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locationListener);
    }
}

