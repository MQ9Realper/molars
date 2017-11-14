package com.molars.molars.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.molars.molars.R;
import com.molars.molars.utils.Utils;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private Utils utils;
    private Toolbar toolbar;
    private GoogleMap mMap;
    private ArrayList<LatLng> locations;
    private ArrayList<String> locationTitles;
    private ArrayList<BitmapDescriptor> bitmapDescriptors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        utils = new Utils(this, this);
        toolbar = (Toolbar) findViewById(R.id.toolbarLocation);

        utils.initToolbar(toolbar, "Our Location", DashboardActivity.class);

        initMap();

        initLocations();
    }

    private void initLocations() {
        locations = new ArrayList<>();
        locations.add(new LatLng(-1.2879583, 36.8238225));
        locations.add(new LatLng(-1.2901327, 36.7975721));

        locationTitles = new ArrayList<>();
        locationTitles.add("Electricity house Harambee Avenue Nairobi");
        locationTitles.add("Lenana Rd next to Kenya Pharmacy and Poisons Board");

        bitmapDescriptors = new ArrayList<>();
        bitmapDescriptors.add(getMarkerIcon("#ee4403"));
        bitmapDescriptors.add(getMarkerIcon("#ee03ad"));

    }

    private void initMap() {
        try {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < locations.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions().position(locations.get(i)).icon(bitmapDescriptors.get(i));
            markerOptions.title(locationTitles.get(i));
            mMap.addMarker(markerOptions);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations.get(0), 13));

        mMap.setTrafficEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public BitmapDescriptor getMarkerIcon(String color) {
        float[] hsv = new float[3];
        Color.colorToHSV(Color.parseColor(color), hsv);
        return BitmapDescriptorFactory.defaultMarker(hsv[0]);
    }
}
