package com.example.geocalc.Methods.Models;

public class AzimuthMethodModel implements IMethodModel
{
    public double FirstX;
    public double FirstY;
    public double SecondX;
    public double SecondY;

    public AzimuthMethodModel(String firstX, String firstY, String secondX, String secondY)
    {
        FirstX = Double.parseDouble(firstX);
        FirstY = Double.parseDouble(firstY);
        SecondX = Double.parseDouble(secondX);
        SecondY = Double.parseDouble(secondY);
    }

}
