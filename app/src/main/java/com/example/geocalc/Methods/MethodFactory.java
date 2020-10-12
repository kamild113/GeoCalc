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

            case RectangularOffsetsMethod:
                return new RectangularOffsetsMethod();

            case CoordinatesDistanceMethod:
                return new CoordinatesDistanceMethod();

            case SurfaceAreaMethod:
                return new SurfaceAreaMethod();

            case AngularIndentation:
                return new AngularIndentationMethod();

            default:
                throw new Exception("Not implemented method.");
        }
    }

}
