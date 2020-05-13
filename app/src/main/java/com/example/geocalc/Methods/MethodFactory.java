package com.example.geocalc.Methods;

import com.example.geocalc.Enums.MethodType;

public class MethodFactory
{

    public ICalcMethod GetMethod(MethodType methodType) throws Exception
    {
        switch (methodType)
        {
            case AzimuthMethod:
                return new AzimuthMethod();

            case PolarMethod:
                return new PolarMethod();

            default:
                throw new Exception("Not implemented method.");
        }
    }

}
