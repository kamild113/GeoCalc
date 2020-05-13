package com.example.geocalc.Activities;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Geolocation.LocationProvider;
import com.example.geocalc.Methods.Models.AzimuthMethodModel;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

public class AzimuthCalc extends CalcActivity
{

    ProgressDialog _mDialog;
    LocationProvider _locationProvider;
    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.azimuth_calc);
        _mDialog = new ProgressDialog(this);
        _locationProvider = new LocationProvider(this);

        AddListeners();
    }

    private void AddListeners()
    {
        Button firstCoordinateButton = findViewById(R.id.azimuthFirstCoordinateButton);
        firstCoordinateButton.setOnClickListener(ButtonClickListener(firstLocationCallback));

        Button secondCoordinateButton = findViewById(R.id.azimuthSecondCoordinateButton);
        secondCoordinateButton.setOnClickListener(ButtonClickListener(secondLocationCallback));

        CreateInputsListeners();
    }

    private void CreateInputsListeners()
    {
        _firstX = findViewById(R.id.azimuthFirstX);
        _firstY = findViewById(R.id.azimuthFirstY);
        _secondX = findViewById(R.id.azimuthSecondX);
        _secondY = findViewById(R.id.azimuthSecondY);
        TextView resultView = findViewById(R.id.azimuthResult);

        InputWatcher(resultView, _firstX, _firstY, _secondX, _secondY);
    }

    private View.OnClickListener ButtonClickListener(final LocationCallback callback)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                _mDialog.setMessage("Pobieranie współrzędnych");
                _mDialog.setCancelable(false);
                if(_locationProvider.RequestNewLocationData(callback))
                {
                    _mDialog.show();
                }
            }
        };
    }

    private LocationCallback firstLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            _firstX.setText(mLastLocation.getLatitude()+"");
            _firstY.setText(mLastLocation.getLongitude()+"");

            _mDialog.dismiss();
        }
    };

    private LocationCallback secondLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            _secondX.setText(mLastLocation.getLatitude()+"");
            _secondY.setText(mLastLocation.getLongitude()+"");

            _mDialog.dismiss();
        }
    };

    @Override
    protected MethodType GetMethod()
    {
        return MethodType.AzimuthMethod;
    }

    @Override
    protected IMethodModel GetModel()
    {
        return new AzimuthMethodModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString()
        );
    }
}
