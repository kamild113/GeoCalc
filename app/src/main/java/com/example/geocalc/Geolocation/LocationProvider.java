package com.example.geocalc.Geolocation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Looper;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class LocationProvider
{
    int PERMISSION_ID = 44;
    Activity _activity;

    FusedLocationProviderClient _fusedClient;

    public LocationProvider(Activity activity)
    {
        _activity = activity;
    }

    public void RequestPermissions()
    {
        ActivityCompat.requestPermissions(
                _activity,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    @SuppressLint("MissingPermission")
    public boolean RequestNewLocationData(LocationCallback callback)
    {
        if(!CheckLocationPermissions())
        {
            RequestPermissions();
            return false;
        }

        if(!IsLocationEnabled())
        {
            Toast.makeText(_activity, "GPS wyłączony", Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            LocationRequest mLocationRequest = new LocationRequest();
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            mLocationRequest.setInterval(5000);
            mLocationRequest.setFastestInterval(5000);
            mLocationRequest.setNumUpdates(1);

            _fusedClient = LocationServices.getFusedLocationProviderClient(_activity);
            _fusedClient.requestLocationUpdates(
                    mLocationRequest, callback,
                    Looper.myLooper()
            );

            return true;
        }
    }

    private boolean CheckLocationPermissions()
    {
        if (ActivityCompat.checkSelfPermission(_activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(_activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }

        return false;
    }

    private boolean IsLocationEnabled()
    {
        LocationManager locationManager = (LocationManager) _activity.getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}
