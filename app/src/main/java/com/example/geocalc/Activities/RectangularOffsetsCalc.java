package com.example.geocalc.Activities;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Geolocation.LocationProvider;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.RectangularOffsetsMethodModel;
import com.example.geocalc.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

public class RectangularOffsetsCalc extends CalcActivity
{
    ProgressDialog _mDialog;
    LocationProvider _locationProvider;
    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;
    EditText _thirdX;
    EditText _thirdY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rectangular_offsets_calc);

        _mDialog = new ProgressDialog(this);
        _locationProvider = new LocationProvider(this);

        AddListeners();
    }

    private void AddListeners()
    {
        Button firstCoordinateButton = findViewById(R.id.rectFirstCoordinateButton);
        firstCoordinateButton.setOnClickListener(ButtonClickListener(firstLocationCallback));

        Button secondCoordinateButton = findViewById(R.id.rectSecondCoordinateButton);
        secondCoordinateButton.setOnClickListener(ButtonClickListener(secondLocationCallback));

        Button thirdCoordinateButton = findViewById(R.id.rectThirdCoordinateButton);
        thirdCoordinateButton.setOnClickListener(ButtonClickListener(thirdLocationCallback));

        CreateInputsListeners();
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

    private LocationCallback thirdLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            _thirdX.setText(mLastLocation.getLatitude()+"");
            _thirdY.setText(mLastLocation.getLongitude()+"");

            _mDialog.dismiss();
        }
    };

    @Override
    protected void CreateInputsListeners()
    {
        super.CreateInputsListeners();

        Button calcButton = findViewById(R.id.calcButton);

        _firstX = findViewById(R.id.rectFirstX);
        _firstY = findViewById(R.id.rectFirstY);
        _secondX = findViewById(R.id.rectSecondX);
        _secondY = findViewById(R.id.rectSecondY);
        _thirdX = findViewById(R.id.rectThirdX);
        _thirdY = findViewById(R.id.rectThirdY);

        InputWatcher(calcButton, _firstX, _firstY, _secondX, _secondY, _thirdX, _thirdY);
    }

    @Override
    protected MethodType GetMethod() {
        return MethodType.RectangularOffsetsMethod;
    }

    @Override
    protected IMethodModel GetModel() {
        return new RectangularOffsetsMethodModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString(),
                _thirdX.getText().toString(),
                _thirdY.getText().toString()
        );
    }
}
