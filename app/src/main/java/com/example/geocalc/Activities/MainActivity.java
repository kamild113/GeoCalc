package com.example.geocalc.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.geocalc.Components.MainMenu;
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
    }

    public static Context getAppContext()
    {
        return MainActivity.context;
    }

}
