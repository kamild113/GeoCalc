package com.example.geocalc.Components;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.geocalc.Activities.MainActivity;

public class MainMenuItem
{

    private String title;
    private String description;
    private ImageView icon;
    private int color;
    private Context context;
    private View.OnClickListener onClickListener;

    public MainMenuItem(String title, String description, ImageView icon, int color)
    {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.color = color;
        this.context = MainActivity.getAppContext();
    }

    public void SetOnClickListener(View.OnClickListener listener)
    {
        this.onClickListener = listener;
    }

    public TableLayout Build()
    {
        TableLayout item = new TableLayout(this.context);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tableParams.bottomMargin = 80;

        item.setLayoutParams(tableParams);
        item.setStretchAllColumns(true);
        item.setShrinkAllColumns(true);

        TableRow row = new TableRow(this.context);
        row.setGravity(Gravity.CENTER_VERTICAL);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rowParams.gravity = Gravity.CENTER_VERTICAL;
        row.setLayoutParams(rowParams);

        ImageView itemIcon = CreateIcon();
        TextView title = CreateTitle();
        TextView description = CreateDescription();

        LinearLayout texts = new LinearLayout(this.context);
        texts.setOrientation(LinearLayout.VERTICAL);

        texts.addView(title);
        texts.addView(description);

        row.addView(itemIcon);
        row.addView(texts);

        item.addView(row);
        item.setOnClickListener(onClickListener);

        return item;
    }

    private ImageView CreateIcon()
    {
        ImageView result = icon;
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        params.width = 150;
        params.gravity = Gravity.CENTER_VERTICAL;
        params.setMargins(30, 0, 30, 0);

        result.setLayoutParams(params);

        return result;
    }

    private TextView CreateTitle()
    {
        TextView titleTextView = new TextView(this.context);
        titleTextView.setText(this.title);
        titleTextView.setTextColor(color);
        titleTextView.setTextSize(20);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.topMargin = 10;
        params.width = 500;

        titleTextView.setLayoutParams(params);

        return titleTextView;
    }

    private TextView CreateDescription()
    {
        TextView descriptionTextView = new TextView(this.context);
        descriptionTextView.setText(this.description);
        descriptionTextView.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        descriptionTextView.setTextColor(Color.parseColor("#9e9e9e"));

        TableRow.LayoutParams params = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 40;

        descriptionTextView.setLayoutParams(params);

        return descriptionTextView;
    }
}
