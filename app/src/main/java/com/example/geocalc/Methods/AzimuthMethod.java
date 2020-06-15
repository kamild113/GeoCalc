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
        double dxab = _model.SecondX - _model.FirstX;
        double dyab = _model.SecondY - _model.FirstY;

        double result = Math.abs(dyab/dxab);

        return Double.isNaN(result) ? "Błędne dane" : Double.toString(result);
    }

}
