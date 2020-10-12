package com.example.geocalc.Activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geocalc.Enums.MethodType;
import com.example.geocalc.Geolocation.LocationProvider;
import com.example.geocalc.Methods.ICalcMethod;
import com.example.geocalc.Methods.MethodFactory;
import com.example.geocalc.Methods.Models.IMethodModel;
import com.example.geocalc.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

public abstract class CalcActivity extends AppCompatActivity
{

    ProgressDialog _locationDialog;
    LocationProvider _locationProvider;

    protected abstract MethodType GetMethod();

    protected abstract IMethodModel GetModel();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _locationDialog = new ProgressDialog(this);
        _locationProvider = new LocationProvider(this);
    }

    protected View.OnClickListener locationButtonListener(final EditText x, final EditText y)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                _locationDialog.setMessage("Pobieranie współrzędnych");
                _locationDialog.setCancelable(false);
                if(_locationProvider.RequestNewLocationData(getLocationCallBack(x, y)))
                {
                    _locationDialog.show();
                }
            }
        };
    }

    private LocationCallback getLocationCallBack(final EditText x, final EditText y)
    {
        return new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Location mLastLocation = locationResult.getLastLocation();

                x.setText(mLastLocation.getLatitude()+"");
                y.setText(mLastLocation.getLongitude()+"");

                _locationDialog.dismiss();
            }
        };
    }

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

        final EditText resultTextBox = dialogView.findViewById(R.id.resultTextBox);
        resultTextBox.setText(Calc());
        resultTextBox.setKeyListener(null);

        Button copyButton = dialogView.findViewById(R.id.copyButton);

        final Context context = this;

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appName = getResources().getString(R.string.app_name);

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(appName, resultTextBox.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context, "Skopiowano", Toast.LENGTH_SHORT).show();
            }
        });

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
