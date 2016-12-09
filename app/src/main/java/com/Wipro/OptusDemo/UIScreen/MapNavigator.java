package com.Wipro.OptusDemo.UIScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by AP359544 on 12/8/2016.
 */
public class MapNavigator extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    double latt=12.97;
    double longg=77.59;
    String placeName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_tool_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent lIntent = getIntent();
        if(lIntent!=null){
            latt=lIntent.getDoubleExtra("LAT",latt);
            longg=lIntent.getDoubleExtra("LONG",longg);
            placeName=lIntent.getStringExtra("PLACE");
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng place = new LatLng(latt,longg);
        mMap.addMarker(new
                MarkerOptions().position(place).title(placeName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f));
    }
}
