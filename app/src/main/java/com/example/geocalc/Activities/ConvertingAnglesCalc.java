package com.example.geocalc.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.geocalc.R;

public class ConvertingAnglesCalc extends AppCompatActivity
{

    Spinner _firstSpinner;
    Spinner _secondSpinner;
    EditText _input;
    EditText _angleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.converting_angles_calc);

        fillSpinners();
    }

    private void fillSpinners()
    {

        _firstSpinner = findViewById(R.id.firstAngleSpinner);
        _secondSpinner = findViewById(R.id.secondAngleSpinner);
        _input = findViewById(R.id.angleInput);
        _angleResult = findViewById(R.id.angleResult);

        _secondSpinner.setSelection(1);

        _input.addTextChangedListener(InputWatcher());
        _firstSpinner.setOnItemSelectedListener(ChangeListener());
        _secondSpinner.setOnItemSelectedListener(ChangeListener());
    }

    private AdapterView.OnItemSelectedListener ChangeListener()
    {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Calc();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        };
    }

    private void Calc()
    {
        String convertFrom = _firstSpinner.getSelectedItem().toString();
        String convertTo = _secondSpinner.getSelectedItem().toString();
        String number = _input.getText().toString();

        if(!number.isEmpty())
        {
            String result = Convert(convertFrom, convertTo, Double.parseDouble(number));
            _angleResult.setText(result);
        }
        else
        {
            _angleResult.setText("");
        }
    }

    private TextWatcher InputWatcher()
    {
        TextWatcher watcher =  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s)
            {
                Calc();
            }
        };

        return watcher;
    }

    private String Convert(String convertFrom, String convertTo, double number)
    {
        switch (convertFrom)
        {
            case "Stopnie":
                return String.valueOf(ConvertDegrees(convertTo, number));

            case "Radiany":
                return String.valueOf(ConvertRads(convertTo, number));

            case "Grady":
                return String.valueOf(ConvertGrads(convertTo, number));
        }

        return "";
    }

    private Double ConvertDegrees(String convertTo, double number)
    {
        if(convertTo.contains("Radiany"))
        {
            return (number * Math.PI) / 180;
        }
        else if (convertTo.contains("Grady"))
        {
            return number * (Math.pow(10, number) / 9);
        }
        else
        {
            return number;
        }
    }

    private Double ConvertRads(String convertTo, double number)
    {
        if(convertTo.contains("Stopnie"))
        {
            return (number * 180) / Math.PI;
        }
        else if (convertTo.contains("Grady"))
        {
            return number;
        }
        else
        {
            return number;
        }
    }

    private Double ConvertGrads(String convertTo, double number)
    {
        if(convertTo.contains("Stopnie"))
        {
            return number;
        }
        else if (convertTo.contains("Radiany"))
        {
            return number;
        }
        else
        {
            return number;
        }
    }
}
