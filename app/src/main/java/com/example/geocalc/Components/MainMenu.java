package com.example.geocalc.Components;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.geocalc.Activities.AngularIndentationCalc;
import com.example.geocalc.Activities.AzimuthCalc;
import com.example.geocalc.Activities.ConvertingAnglesCalc;
import com.example.geocalc.Activities.CoordinatesDistanceCalc;
import com.example.geocalc.Activities.LinearIndentationCalc;
import com.example.geocalc.Activities.MainActivity;
import com.example.geocalc.Activities.PolarMethodCalc;
import com.example.geocalc.Activities.RectangularOffsetsCalc;
import com.example.geocalc.Activities.SurfaceAreaCalc;
import com.example.geocalc.R;

import java.util.ArrayList;
import java.util.List;

public class MainMenu
{

    private AppCompatActivity activity;

    public MainMenu(AppCompatActivity activity)
    {
        this.activity = activity;
    }

    public void CreateMenu()
    {
        LinearLayout mainMenu = this.activity.findViewById(R.id.main_menu);
        List<MainMenuItem> menuItems = CreateMenuItems();

        for (MainMenuItem item : menuItems)
        {
            mainMenu.addView(item.Build());
        }
    }

    private List<MainMenuItem> CreateMenuItems()
    {
        List<MainMenuItem> menuItems = new ArrayList<>();
        menuItems.add(AzimuthCalcMethod());
        //menuItems.add(PolarMethodMethod());
        menuItems.add(RectangularOffsetsMethod());
        //menuItems.add(ConvertingAnglesMethod());
        menuItems.add(CoordinatesDistanceMethod());
        //menuItems.add(SurfaceAreaMethod());
        menuItems.add(AngularIndentationMethod());
        menuItems.add(LinearIndentationMethod());

        return menuItems;
    }

    private MainMenuItem AzimuthCalcMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.azymut);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.azimuthCalcTitle),
                activity.getResources().getString(R.string.azimuthCalcDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.azimuthColor));

        item.SetOnClickListener(CreateClickListener(AzimuthCalc.class));

        return item;
    }

    private MainMenuItem PolarMethodMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.biegunowa);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.polarMethodTitle),
                activity.getResources().getString(R.string.polarMethodDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.polarColor));

        item.SetOnClickListener(CreateClickListener(PolarMethodCalc.class));

        return item;
    }

    private MainMenuItem RectangularOffsetsMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.domiary);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.rectangularOffsetsTitle),
                activity.getResources().getString(R.string.rectangularOffsetsDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.rectangularColor));

        item.SetOnClickListener(CreateClickListener(RectangularOffsetsCalc.class));

        return item;
    }

    private MainMenuItem ConvertingAnglesMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.katy);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.convertingAnglesTitle),
                activity.getResources().getString(R.string.convertingAnglesDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.anglesColor));

        item.SetOnClickListener(CreateClickListener(ConvertingAnglesCalc.class));

        return item;
    }

    private MainMenuItem CoordinatesDistanceMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.domiar);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.coordinatesDistanceTitle),
                activity.getResources().getString(R.string.coordinatesDistanceDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.distanceColor));

        item.SetOnClickListener(CreateClickListener(CoordinatesDistanceCalc.class));

        return item;
    }

    private MainMenuItem SurfaceAreaMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.katy);
        icon = icon.getConstantState().newDrawable().mutate();
        icon.setColorFilter(activity.getResources().getColor(R.color.surfaceAreaColor), PorterDuff.Mode.SRC_IN);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.surfaceAreaTitle),
                activity.getResources().getString(R.string.surfaceAreaDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.surfaceAreaColor));

        item.SetOnClickListener(CreateClickListener(SurfaceAreaCalc.class));

        return item;
    }

    private MainMenuItem AngularIndentationMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.katowe);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.angularIndentationTitle),
                activity.getResources().getString(R.string.angularIndentationDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.angularIndentationColor));

        item.SetOnClickListener(CreateClickListener(AngularIndentationCalc.class));

        return item;
    }

    private MainMenuItem LinearIndentationMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.liniowe);

        MainMenuItem item = new MainMenuItem(
                activity.getResources().getString(R.string.linearIndentationTitle),
                activity.getResources().getString(R.string.linearIndentationDesc),
                CreateIcon(icon),
                activity.getResources().getColor(R.color.linearIndentationColor));

        item.SetOnClickListener(CreateClickListener(LinearIndentationCalc.class));

        return item;
    }

    private ImageView CreateIcon(Drawable icon)
    {
        ImageView iconView = new ImageView(MainActivity.getAppContext());
        iconView.setImageDrawable(icon);

        return iconView;
    }

    private View.OnClickListener CreateClickListener(final Class classToOpen)
    {
        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                activity.startActivity(new Intent(activity, classToOpen));
            }
        };

        return clickListener;
    }
}
