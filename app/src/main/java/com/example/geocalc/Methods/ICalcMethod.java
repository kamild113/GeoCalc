package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.IMethodModel;

public interface ICalcMethod
{

    void FillData(IMethodModel model);

    String Calc();

}
