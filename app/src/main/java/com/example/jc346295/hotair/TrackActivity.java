package com.example.jc346295.hotair;

/**
 * Created by Diraj Ravikumar on 14/5/17.
 */

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class TrackActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    ImageButton reportButton;
    ImageButton historyButton;
    ImageButton trackButton;
    GoogleMap map;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, this);

        reportButton = (ImageButton) findViewById(R.id.reportButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        trackButton = (ImageButton) findViewById(R.id.trackButton);
    }

    public void onClick(View view) {
        if (view == reportButton) {
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        } else if (view == historyButton) {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        } else if (view == trackButton) {
            Intent intent = new Intent(this, TrackActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    @Override
    public void onLocationChanged(Location location) {
        map.clear();
        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(currentLocation);
        markerOptions.title("Your order is here");

        map.addMarker(markerOptions);

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 17.0f));

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

}
