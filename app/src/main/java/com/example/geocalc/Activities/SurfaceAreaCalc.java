package com.example.geocalc.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Geolocation.LocationProvider;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.SurfaceAreaModel;
import com.example.geocalc.R;

public class SurfaceAreaCalc extends CalcActivity {

    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;
    EditText _thirdX;
    EditText _thirdY;
    EditText _fourthX;
    EditText _fourthY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_area_calc);

        AddListeners();
    }

    private void AddListeners()
    {
        CreateInputsListeners();

        Button firstCoordinateButton = findViewById(R.id.firstCoordinateButton);
        firstCoordinateButton.setOnClickListener(locationButtonListener(_firstX, _firstY));

        Button secondCoordinateButton = findViewById(R.id.secondCoordinateButton);
        secondCoordinateButton.setOnClickListener(locationButtonListener(_secondX, _secondY));

        Button thirdCoordinateButton = findViewById(R.id.thirdCoordinateButton);
        thirdCoordinateButton.setOnClickListener(locationButtonListener(_thirdX, _thirdY));

        Button fourthCoordinateButton = findViewById(R.id.fourthCoordinateButton);
        fourthCoordinateButton.setOnClickListener(locationButtonListener(_fourthX, _fourthY));
    }

    @Override
    protected void CreateInputsListeners()
    {
        super.CreateInputsListeners();
        Button calcButton = findViewById(R.id.calcButton);

        _firstX = findViewById(R.id.firstX);
        _firstY = findViewById(R.id.firstY);
        _secondX = findViewById(R.id.secondX);
        _secondY = findViewById(R.id.secondY);
        _thirdX = findViewById(R.id.thirdX);
        _thirdY = findViewById(R.id.thirdY);
        _fourthX = findViewById(R.id.fourthX);
        _fourthY = findViewById(R.id.fourthY);

        InputWatcher(calcButton, _firstX, _firstY, _secondX, _secondY, _thirdX, _thirdY, _fourthX, _fourthY);
    }

    @Override
    protected MethodType GetMethod() {
        return MethodType.SurfaceAreaMethod;
    }

    @Override
    protected IMethodModel GetModel() {
        return new SurfaceAreaModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString(),
                _thirdX.getText().toString(),
                _thirdY.getText().toString(),
                _fourthX.getText().toString(),
                _fourthY.getText().toString()
        );
    }
}
