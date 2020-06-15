package com.example.geocalc.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.R;

public class RectangularOffsetsCalc extends CalcActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rectangular_offsets_calc);

        AddListeners();
    }

    private void AddListeners()
    {
        CreateInputsListeners();
    }

    @Override
    protected void CreateInputsListeners()
    {
        super.CreateInputsListeners();
    }

    @Override
    protected MethodType GetMethod() {
        return MethodType.RectangularOffsetsMethod;
    }

    @Override
    protected IMethodModel GetModel() {
        return null;
    }
}
