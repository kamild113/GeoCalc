package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.PolarMethodModel;

public class PolarMethod implements ICalcMethod
{

    PolarMethodModel _model;

    @Override
    public void FillData(IMethodModel model)
    {
        _model = (PolarMethodModel) model;
    }

    @Override
    public String Calc()
    {
        return "Do zrobienia";
    }

}
