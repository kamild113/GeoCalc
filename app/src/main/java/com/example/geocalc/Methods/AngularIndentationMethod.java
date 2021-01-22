package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.AngularIndentationModel;
import com.example.geocalc.Methods.Models.IMethodModel;

public class AngularIndentationMethod implements ICalcMethod {

    AngularIndentationModel _model;
    final int _resultPrecision = 4;

    @Override
    public void FillData(IMethodModel model) {
        _model = (AngularIndentationModel) model;
    }

    @Override
    public String Calc() {

        try {
            double XP = (_model.XA * ctg(_model.Beta) - (-1) * _model.YA + _model.XB * ctg(_model.Alpha) - 1 * _model.YB) /
                    (-1 + ctg(_model.Beta) + 1 + ctg(_model.Alpha));

            double YP = (_model.XA * (-1) + _model.YA * ctg(_model.Beta) + _model.XB * 1 + _model.YB * ctg(_model.Alpha)) /
                    (-1 + ctg(_model.Beta) + 1 + ctg(_model.Alpha));

            String XpRounded =  String.format("%." + _resultPrecision + "f", XP);
            String YpRounded =  String.format("%." + _resultPrecision + "f", YP);

            return "XP: " + XpRounded + "\n" +
                    "YP: " + YpRounded;
        }
        catch (Exception ex) {
            return "Błędne dane";
        }
    }


    private double ctg(double value) {
        return 1.0 / Math.tan(value);
    }
}
