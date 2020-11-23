package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.LinearIndentationModel;

public class LinearIndentationMethod implements ICalcMethod {

    LinearIndentationModel _model;
    final int _resultPrecision = 8;

    @Override
    public void FillData(IMethodModel model)
    {
        _model = (LinearIndentationModel) model;
    }


    @Override
    public String Calc() {

        try {
            double AB = (Math.sqrt(((_model.XB - _model.XA) * (_model.XB - _model.XA)) +
                    ((_model.YB - _model.YA) * (_model.YB - _model.YA))));

            double Ca = (-1) * Math.pow(_model.BP, 2) + Math.pow(_model.AP, 2) + Math.pow(AB, 2);
            double Cb = Math.pow(_model.BP, 2) + (-1) * Math.pow(_model.AP, 2) + Math.pow(AB, 2);
            double Cc = Math.pow(_model.BP, 2) + Math.pow(_model.AP, 2) + (-1) * Math.pow(AB, 2);

            double P4 = Math.sqrt(Math.abs(Ca * Cb + Ca * Cc + Cb * Cc));

            double A = _model.XA * Cb + (-1) * P4 * _model.YA + _model.XB * Ca + P4 * _model.YB;
            double B = _model.XA * (-1) * P4 + _model.YA * Cb + _model.XB * P4 + _model.YB * Ca;

            double C = Ca + Cb;
            double X = A/C;
            double Y = B/C;

            return String.format("X = %." + _resultPrecision + "f\n" +
                    "Y = %." + _resultPrecision + "f", X, Y);
        }
        catch (Exception ex) {
            return "Błędne dane";
        }
    }
}
