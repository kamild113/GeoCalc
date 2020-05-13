package com.example.geocalc.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.geocalc.Components.MainMenu;
import com.example.geocalc.Geolocation.LocationProvider;
import com.example.geocalc.R;

public class MainActivity extends AppCompatActivity
{
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);
        MainActivity.context = getApplicationContext();

        MainMenu menu = new MainMenu(this);
        menu.CreateMenu();

        LocationProvider provider = new LocationProvider(this);
        provider.RequestPermissions();
    }

    public static Context getAppContext()
    {
        return MainActivity.context;
    }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Granted. Start getting the location information
            }
        }
    }*/
}
