package com.example.jc346295.hotair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.MapView;


public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        //fetch the map view from the layout
        MapView mapView = (MapView) findViewById(R.id.mapview);
    }
}
