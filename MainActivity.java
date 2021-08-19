package com.example.currencyconvert;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.RadioButton;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ButtonClick(View v){

        Button btn = (Button) v;
        RadioGroup radioGroup = findViewById(R.id.currRadioGroup);
        Intent myIntent = new Intent(this, SecondActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkId = radioGroup.getCheckedRadioButtonId();
                double currEx = findRadioButton(checkId);
                String currName = findCurrencyType(checkId);
                myIntent.putExtra("CurrencySelection", currEx);
                myIntent.putExtra("CurrencyType", currName);

                startActivity(myIntent);

            }
        });

    }

    private String findCurrencyType(int checkId) {
        String result = "";
        switch(checkId){

            case R.id.CADButton:
                result = "CAD";
                break;
            case R.id.YENButton:
                result = "YEN";
                break;
            case R.id.EURButton:
                result = "EUR";
                break;
        }

        return result;
    }

    private double findRadioButton(int checkId) {
        double result = 0.0;
        switch(checkId){

            case R.id.CADButton:
                result = 1.35;
                break;
            case R.id.YENButton:
                result = 109.54;
                break;
            case R.id.EURButton:
                result = 0.90;
                break;
        }

        return result;

    }
}