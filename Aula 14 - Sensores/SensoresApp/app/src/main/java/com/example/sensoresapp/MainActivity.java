package com.example.sensoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    private LocationRequest locationRequest;
    private Task<Location> location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context. SENSOR_SERVICE);

        // Listando sensores que o celular possui:

        List<Sensor> listSensors = sensorManager.getSensorList(Sensor. TYPE_ALL);

        for (Sensor s : listSensors) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {

                Log.i("Main", s.getStringType());
            }
        }

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission. ACCESS_COARSE_LOCATION,
                        Manifest.permission. ACCESS_FINE_LOCATION
                ).withListener(new MultiplePermissionsListener() {

            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {

                lastLocation();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }

        }).check();
    }

    public void lastLocation(){

        location = LocationServices. getFusedLocationProviderClient(this).getLastLocation();

        if (location != null) {

            location.addOnSuccessListener( new OnSuccessListener<Location>() {

                @Override
                public void onSuccess(Location location) {
                    Log.i("Main", location.getLatitude() + " " + location.getLongitude());
                }
            });
        }
    }

    private void startLocationUpdates() {

        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest. PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(2000);

        LocationServices. getFusedLocationProviderClient(this).requestLocationUpdates
                (locationRequest, new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) { return; }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {

                        Log.i("Main", location.getLatitude() + " " + location.getLongitude());
                    }
                }
            }
        }, Looper. myLooper());
    }
}
