package com.example.geocalc.Methods.Models;

public class RectangularOffsetsMethodModel implements IMethodModel
{

    public double XA;
    public double YA;
    public double XB;
    public double YB;
    public double XP;
    public double YP;

    public RectangularOffsetsMethodModel(String xa, String ya, String xb, String yb, String xp, String yp)
    {
        XA = Double.parseDouble(xa);
        YA = Double.parseDouble(ya);
        XB = Double.parseDouble(xb);
        YB = Double.parseDouble(yb);
        XP = Double.parseDouble(xp);
        YP = Double.parseDouble(yp);
    }

}
