package com.example.geocalc.Methods.Models;

public class PolarMethodModel implements IMethodModel
{
    public double FirstX;
    public double FirstY;
    public double SecondX;
    public double SecondY;
    public double Distance;
    public double Angle;

    public PolarMethodModel(String firstX, String firstY, String secondX, String secondY, String distance, String angle)
    {
        FirstX = Double.parseDouble(firstX);
        FirstY = Double.parseDouble(firstY);
        SecondX = Double.parseDouble(secondX);
        SecondY = Double.parseDouble(secondY);
        Distance = Double.parseDouble(distance);
        Angle = Double.parseDouble(angle);
    }

}
