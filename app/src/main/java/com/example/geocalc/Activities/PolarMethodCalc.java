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
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.PolarMethodModel;
import com.example.geocalc.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

public class PolarMethodCalc extends CalcActivity
{

    ProgressDialog mDialog;
    LocationProvider _locationProvider;
    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;
    EditText _distance;
    EditText _angle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.polar_method_calc);

        mDialog = new ProgressDialog(this);
        _locationProvider = new LocationProvider(this);

        AddListeners();
    }

    private void AddListeners()
    {
        Button firstCoordinateButton = findViewById(R.id.polarFirstCoordinateButton);
        firstCoordinateButton.setOnClickListener(ButtonClickListener(firstLocationCallback));

        Button secondCoordinateButton = findViewById(R.id.polarSecondCoordinateButton);
        secondCoordinateButton.setOnClickListener(ButtonClickListener(secondLocationCallback));

        CreateInputsListeners();
    }

    protected void CreateInputsListeners()
    {
        super.CreateInputsListeners();

        _firstX = findViewById(R.id.polarFirstX);
        _firstY = findViewById(R.id.polarFirstY);
        _secondX = findViewById(R.id.polarSecondX);
        _secondY = findViewById(R.id.polarSecondY);
        _distance = findViewById(R.id.polarDistance);
        _angle = findViewById(R.id.polarAngle);
        Button calcButton = findViewById(R.id.calcButton);

        InputWatcher(calcButton, _firstX, _firstY, _secondX, _secondY, _distance, _angle);
    }

    private View.OnClickListener ButtonClickListener(final LocationCallback callback)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mDialog.setMessage("Pobieranie współrzędnych");
                mDialog.setCancelable(false);
                if(_locationProvider.RequestNewLocationData(callback))
                {
                    mDialog.show();
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

            mDialog.dismiss();
        }
    };

    private LocationCallback secondLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            _secondX.setText(mLastLocation.getLatitude()+"");
            _secondY.setText(mLastLocation.getLongitude()+"");

            mDialog.dismiss();
        }
    };

    @Override
    protected MethodType GetMethod()
    {
        return MethodType.PolarMethod;
    }

    @Override
    protected IMethodModel GetModel()
    {
        return new PolarMethodModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString(),
                _distance.getText().toString(),
                _angle.getText().toString()
        );
    }
}
