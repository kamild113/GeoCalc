package com.example.geocalc.Methods.Models;

public class CoordinatesDistanceModel implements IMethodModel {

    public double XA;
    public double YA;
    public double XB;
    public double YB;

    public CoordinatesDistanceModel(String xa, String ya, String xb, String yb)
    {
        XA = Double.parseDouble(xa);
        YA = Double.parseDouble(ya);
        XB = Double.parseDouble(xb);
        YB = Double.parseDouble(yb);
    }

}
