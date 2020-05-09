package com.example.geocalc.Components;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.geocalc.Activities.AzimuthCalc;
import com.example.geocalc.Activities.ConvertingAnglesCalc;
import com.example.geocalc.Activities.MainActivity;
import com.example.geocalc.Activities.PolarMethodCalc;
import com.example.geocalc.Activities.RectangularOffsetsCalc;
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
        menuItems.add(AzimuthCalcItem());
        menuItems.add(PolarMethodItem());
        menuItems.add(RectangularOffsetsMethod());
        menuItems.add(ConvertingAnglesMethod());

        return menuItems;
    }

    private MainMenuItem AzimuthCalcItem()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.azymut);

        MainMenuItem item = new MainMenuItem(
                "Obliczanie Azymutu",
                "Obliczanie azymutu ze współrzędnych",
                CreateIcon(icon),
                Color.parseColor("#0F67BE"));

        item.SetOnClickListener(CreateClickListener(AzimuthCalc.class));

        return item;
    }

    private MainMenuItem PolarMethodItem()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.biegunowa);

        MainMenuItem item = new MainMenuItem(
                "Metoda Biegunowa",
                "Obliczanie współrzędnych metodą biegunową",
                CreateIcon(icon),
                Color.parseColor("#218024"));

        item.SetOnClickListener(CreateClickListener(PolarMethodCalc.class));

        return item;
    }

    private MainMenuItem RectangularOffsetsMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.domiary);

        MainMenuItem item = new MainMenuItem(
                "Domiary Prostokątne",
                "Wyznaczanie współrzędnych metodą ortogonalną (Rzędnych i Odciętych)",
                CreateIcon(icon),
                Color.parseColor("#F7CC65"));

        item.SetOnClickListener(CreateClickListener(RectangularOffsetsCalc.class));

        return item;
    }

    private MainMenuItem ConvertingAnglesMethod()
    {
        Drawable icon = ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.katy);

        MainMenuItem item = new MainMenuItem(
                "Przeliczanie Kątów",
                "Przeliczanie jednostek kątowych takich jak: Grady, Stopnie i Radiany",
                CreateIcon(icon),
                Color.parseColor("#8152A9"));

        item.SetOnClickListener(CreateClickListener(ConvertingAnglesCalc.class));

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
