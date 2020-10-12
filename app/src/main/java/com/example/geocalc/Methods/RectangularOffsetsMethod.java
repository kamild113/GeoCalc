package com.example.geocalc.Methods;

import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.Methods.Models.RectangularOffsetsMethodModel;


public class RectangularOffsetsMethod implements ICalcMethod {

    RectangularOffsetsMethodModel _model;

    final int _resultPrecision = 8;

    @Override
    public void FillData(IMethodModel model)
    {
        _model = (RectangularOffsetsMethodModel) model;
    }

    @Override
    public String Calc()
    {
        try {
            String abscissa = CalcAbscissa();
            String ordinate = CalcOrdinate();

            return "Rzędna = " + abscissa + "\n\n" + "Odcięta = " + ordinate;
        }
        catch (Exception ex) {
            return "Błędne dane";
        }
    }

    /**
     * Obliczanie odciętej
     * @return odcięta
     */
    private String CalcAbscissa()
    {
        double result = (_model.YA - _model.YP) * ((_model.XA - _model.XB) / Math.sqrt(Math.pow(_model.XA - _model.XB, 2) +
                Math.pow(_model.YA - _model.YB, 2))) - (_model.XA - _model.XP) * ((_model.YA - _model.YB) /
                Math.sqrt(Math.pow(_model.XA - _model.XB, 2) + Math.pow(_model.YA - _model.YB, 2)));

        return String.format("%." + _resultPrecision + "f", result);
    }

    /**
     * Obliczanie rzędnej
     * @return rzędna
     */
    private String CalcOrdinate()
    {
        double result =  (_model.YA - _model.YP) * ((_model.YA - _model.YB) / Math.sqrt(Math.pow(_model.XA - _model.XB, 2) +
                Math.pow(_model.YA - _model.YB, 2))) + (_model.XA - _model.XP) * ((_model.YA - _model.YB) /
                Math.sqrt(Math.pow(_model.XA - _model.XB, 2) + Math.pow(_model.YA - _model.YB, 2)));

        return String.format("%." + _resultPrecision + "f", result);
    }

}
