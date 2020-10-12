package com.example.geocalc.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Methods.Models.AngularIndentationModel;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.R;

public class AngularIndentationCalc extends CalcActivity {

    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;
    EditText _alpha;
    EditText _beta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angular_indentation_calc);

        AddListeners();
    }

    private void AddListeners()
    {
        CreateInputsListeners();

        Button firstCoordinateButton = findViewById(R.id.firstCoordinateButton);
        firstCoordinateButton.setOnClickListener(locationButtonListener(_firstX, _firstY));

        Button secondCoordinateButton = findViewById(R.id.secondCoordinateButton);
        secondCoordinateButton.setOnClickListener(locationButtonListener(_secondX, _secondY));
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
        _alpha = findViewById(R.id.alpha);
        _beta = findViewById(R.id.beta);

        InputWatcher(calcButton, _firstX, _firstY, _secondX, _secondY, _alpha, _beta);
    }


    @Override
    protected MethodType GetMethod() {
        return MethodType.AngularIndentation;
    }

    @Override
    protected IMethodModel GetModel() {
        return new AngularIndentationModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString(),
                _alpha.getText().toString(),
                _beta.getText().toString()
        );
    }
}
