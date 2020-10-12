package com.example.geocalc.Methods.Models;

public class AngularIndentationModel implements IMethodModel {

    public double XA;
    public double YA;
    public double XB;
    public double YB;
    public double Alpha;
    public double Beta;

    public AngularIndentationModel(String xa, String ya, String xb, String yb, String alpha, String beta)
    {
        XA = Double.parseDouble(xa);
        YA = Double.parseDouble(ya);
        XB = Double.parseDouble(xb);
        YB = Double.parseDouble(yb);
        Alpha = Double.parseDouble(alpha);
        Beta = Double.parseDouble(beta);
    }

}
