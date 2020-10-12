package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.SurfaceAreaModel;

public class SurfaceAreaMethod implements ICalcMethod {

    SurfaceAreaModel _model;

    final int _resultPrecision = 8;

    @Override
    public void FillData(IMethodModel model) {
        _model = (SurfaceAreaModel) model;
    }

    @Override
    public String Calc() {
        double area = (_model.XA + _model.XB) * (_model.YB - _model.YA) +
                (_model.XB + _model.XC) * (_model.YC - _model.YB) -
                (_model.XC + _model.XD) * (_model.YC - _model.YD) -
                (_model.XD + _model.XA) * (_model.YD - _model.YA);

        return String.format("%." + _resultPrecision + "f", area);
    }
}
