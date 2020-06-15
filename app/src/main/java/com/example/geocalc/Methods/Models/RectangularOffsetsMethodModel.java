package com.example.geocalc.Methods.Models;

public class RectangularOffsetsMethodModel implements IMethodModel
{

    public double FirstX;
    public double FirstY;
    public double SecondX;
    public double SecondY;
    public double Abscissa;
    public double Ordinate;

    public RectangularOffsetsMethodModel(String firstX, String firstY, String secondX, String secondY, String abscissa, String ordinate)
    {
        FirstX = Double.parseDouble(firstX);
        FirstY = Double.parseDouble(firstY);
        SecondX = Double.parseDouble(secondX);
        SecondY = Double.parseDouble(secondY);
        Abscissa = Double.parseDouble(abscissa);
        Ordinate = Double.parseDouble(ordinate);
    }

}
