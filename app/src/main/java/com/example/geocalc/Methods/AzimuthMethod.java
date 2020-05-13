package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.AzimuthMethodModel;
import com.example.geocalc.Methods.Models.IMethodModel;

public class AzimuthMethod implements ICalcMethod
{

    AzimuthMethodModel _model;

    @Override
    public void FillData(IMethodModel model)
    {
        _model = (AzimuthMethodModel) model;
    }

    @Override
    public String Calc()
    {
        return "Wynik metody obliczania azymutu";
    }

}
