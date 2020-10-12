package com.example.geocalc.Methods.Models;

public class SurfaceAreaModel implements IMethodModel {

    public double XA;
    public double YA;
    public double XB;
    public double YB;
    public double XC;
    public double YC;
    public double XD;
    public double YD;

    public SurfaceAreaModel(String xa, String ya, String xb, String yb, String xc, String yc, String xd, String yd)
    {
        XA = Double.parseDouble(xa);
        YA = Double.parseDouble(ya);
        XB = Double.parseDouble(xb);
        YB = Double.parseDouble(yb);
        XC = Double.parseDouble(xc);
        YC = Double.parseDouble(yc);
        XD = Double.parseDouble(xd);
        YD = Double.parseDouble(yd);
    }

}
