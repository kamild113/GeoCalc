package com.example.geocalc.Methods.Models;

public class LinearIndentationModel implements IMethodModel {

    public double XA;
    public double YA;
    public double XB;
    public double YB;
    public double BP;
    public double AP;

    public LinearIndentationModel(String xa, String ya, String xb, String yb, String ap, String bp)
    {
        XA = Double.parseDouble(xa);
        YA = Double.parseDouble(ya);
        XB = Double.parseDouble(xb);
        YB = Double.parseDouble(yb);
        AP = Double.parseDouble(ap);
        BP = Double.parseDouble(bp);
    }

}
