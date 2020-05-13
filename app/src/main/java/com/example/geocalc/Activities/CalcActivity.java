package com.example.geocalc.Activities;

import android.text.Editable;
import android.text.TextWatcher;
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

    protected TextWatcher InputWatcher(final TextView resultView, final EditText... inputs)
    {
        TextWatcher watcher =  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(AllInputsFilled(inputs))
                {
                    resultView.setText(Calc());
                }
                else
                {
                    resultView.setText(R.string.fill_data);
                }
            }
        };

        for(EditText input : inputs)
        {
            input.addTextChangedListener(watcher);
        }

        return watcher;
    }

    private String Calc()
    {
        IMethodModel model = GetModel();
        MethodFactory methodFactory = new MethodFactory();

        try
        {
            ICalcMethod polarMethod = methodFactory.GetMethod(GetMethod());
            polarMethod.FillData(model);

            return polarMethod.Calc();
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
