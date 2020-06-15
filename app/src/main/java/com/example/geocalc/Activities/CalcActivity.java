package com.example.geocalc.Activities;

import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Methods.ICalcMethod;
import com.example.geocalc.Methods.MethodFactory;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.R;

public abstract class CalcActivity extends AppCompatActivity
{

    protected abstract MethodType GetMethod();

    protected abstract IMethodModel GetModel();

    protected void CreateInputsListeners()
    {
        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnCalcClick(v);
            }
        });
    }

    protected TextWatcher InputWatcher(final Button calcButton, final EditText... inputs)
    {
        TextWatcher watcher =  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s)
            {
                calcButton.setEnabled(AllInputsFilled(inputs));
            }
        };

        for(EditText input : inputs)
        {
            input.addTextChangedListener(watcher);
        }

        return watcher;
    }

    private void OnCalcClick(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.result_dialog, viewGroup, false);
        builder.setView(dialogView);

        EditText resultTextBox = dialogView.findViewById(R.id.resultTextBox);
        resultTextBox.setText(Calc());
        resultTextBox.setKeyListener(null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private String Calc()
    {
        IMethodModel model = GetModel();
        MethodFactory methodFactory = new MethodFactory();

        try
        {
            ICalcMethod calcMethod = methodFactory.GetMethod(GetMethod());
            calcMethod.FillData(model);

            return calcMethod.Calc();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean AllInputsFilled(EditText... inputs)
    {
        boolean inputsFilled = true;

        for(EditText input : inputs)
        {
            inputsFilled = inputsFilled & input.getText().length() > 0;
        }

        return inputsFilled;
    }
}
