package com.ms.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity  {
    private Context context;
    private TextInputLayout til_inCelsius,til_inFahrenhit;
    private TextInputEditText tie_inCelsius,tie_inFahrenhit;

    public AppCompatTextView act_celsiusConv;
    public AppCompatTextView act_fahrenhitConv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize()
    {
        context = this;

        til_inCelsius = (TextInputLayout) findViewById(R.id.til_inCelsius);
        tie_inCelsius = (TextInputEditText) findViewById(R.id.tie_inCelsius);

        til_inFahrenhit = (TextInputLayout) findViewById(R.id.til_inFarenhit);
        tie_inFahrenhit = (TextInputEditText) findViewById(R.id.tie_inFarenhit);

        act_celsiusConv = (AppCompatTextView)findViewById(R.id.act_celsiusConverted);
        act_fahrenhitConv = (AppCompatTextView) findViewById(R.id.act_farenhitConverted);



        tie_inCelsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (!tie_inCelsius.getText().toString().isEmpty()&&tie_inCelsius.getText().toString()!=null)
                {
                    convertToFarenhit(tie_inCelsius.getText().toString());

                }
                else
                {
                    act_fahrenhitConv.setText("");
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        tie_inFahrenhit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (! tie_inFahrenhit.getText().toString().isEmpty()&& tie_inFahrenhit.getText().toString()!=null)
                {
                    convertToCelsius(tie_inFahrenhit.getText().toString());
                }
                else
                {
                    act_celsiusConv.setText("");
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

    }








    private void convertToFarenhit(String temp)
    {
        act_fahrenhitConv.setVisibility(View.VISIBLE);
        Double temperature = Double.parseDouble(temp);
        double farenhit;
        farenhit = temperature;
        farenhit = (farenhit * 9) / 5 + 32 ;
        act_fahrenhitConv.setText(String.format("%.2f", farenhit) + " \u2109");

    }

    private void convertToCelsius(String temp)
    {
        act_celsiusConv.setVisibility(View.VISIBLE);
        Double temperature = Double.parseDouble(temp);
        double celsius;
        celsius = temperature;
        celsius = (celsius - 32) * 5 / 9;
        act_celsiusConv.setText(String.format("%.2f", celsius)+  " \u2103");

    }
}