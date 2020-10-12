package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.CoordinatesDistanceModel;
import com.example.geocalc.Methods.Models.IMethodModel;

public class CoordinatesDistanceMethod implements ICalcMethod {

    CoordinatesDistanceModel _model;
    final int _resultPrecision = 8;


    @Override
    public void FillData(IMethodModel model) {
        _model = (CoordinatesDistanceModel) model;
    }

    @Override
    public String Calc() {
        try {
            double result = Math.sqrt(Math.pow(_model.XA - _model.XB, 2) + Math.pow(_model.YA - _model.YB, 2));
            return String.format("%." + _resultPrecision + "f", result);
        }
        catch (Exception ex) {
            return "Błędne dane";
        }
    }
}
