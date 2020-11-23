package com.example.geocalc.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.LinearIndentationModel;
import com.example.geocalc.R;

public class LinearIndentationCalc extends CalcActivity {

    EditText _firstX;
    EditText _firstY;
    EditText _secondX;
    EditText _secondY;
    EditText _ap;
    EditText _bp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_indentation_calc);

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
        _ap = findViewById(R.id.ap);
        _bp = findViewById(R.id.bp);

        InputWatcher(calcButton, _firstX, _firstY, _secondX, _secondY, _ap, _bp);
    }

    @Override
    protected MethodType GetMethod() {
        return MethodType.LinearIndentation;
    }

    @Override
    protected IMethodModel GetModel() {
        return new LinearIndentationModel(
                _firstX.getText().toString(),
                _firstY.getText().toString(),
                _secondX.getText().toString(),
                _secondY.getText().toString(),
                _ap.getText().toString(),
                _bp.getText().toString()
        );
    }
}
