package com.example.jc346295.hotair;

/**
 * Created by Diraj Ravikumar on 14/5/17.
 */

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.text.Text;

import static android.content.ContentValues.TAG;


public class TrackActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    ImageButton locationButton;
    ImageButton historyButton;
    ImageButton trackButton;
    ImageButton notifButton;
    ImageButton homeButton;
    GoogleMap map;
    LocationManager locationManager;
    String username;
    TextView welcomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        username = getIntent().getExtras().getString("username");
        welcomeUser = (TextView) findViewById(R.id.welcomeText);
        welcomeUser.setText(getString(R.string.welcome_messages, username));

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

        locationButton = (ImageButton) findViewById(R.id.locationButton);
        historyButton = (ImageButton) findViewById(R.id.historyButton);
        trackButton = (ImageButton) findViewById(R.id.trackButton);
        notifButton = (ImageButton) findViewById(R.id.notifButton);
        homeButton = (ImageButton) findViewById(R.id.homeButton);
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
/***
    public boolean getMapPermission(final Context context, Activity activity) {
        if (ActivityCompat.checkSelfPermission(this , Manifest.permission.ACCESS_COARSE_LOCATION)
                // If user grants permission
                == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG,"Permission is granted");
            return true;
        } else {
            // If user revokes permission
            Log.v(TAG,"Permission is revoked");
            if(ActivityCompat.shouldShowRequestPermissionRationale(TrackActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                new AlertDialog.Builder(context)
                        .setTitle(this.getString(R.string.permission_request))
                        .setMessage(this.getString(R.string.location_permission))
                        .setPositiveButton(this.getString(R.string.continue_settings), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent
                                        (android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.addCategory(Intent.CATEGORY_DEFAULT);
                                i.setData(Uri.parse("package:" + getPackageName()));
                                startActivity(i);
                            }
                        })
                        .setNegativeButton(this.getString(R.string.not_now), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d(TAG, "onClick: Cancelled Permission from App Info");
                            }
                        })
                        .show();
            }
            else
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return false;
        }
    }
***/
}
