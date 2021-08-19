package com.example.currencyconvert;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       double curr = getIntent().getDoubleExtra("CurrencySelection", 0.0);
       String currName = getIntent().getStringExtra("CurrencyType");
       TextView name = (TextView) findViewById(R.id.cType);
       TextView usCurr = (TextView) findViewById(R.id.usValue);
       EditText usView = (EditText) findViewById(R.id.usDollars);
        usView.setText("1");
       EditText forView = (EditText) findViewById(R.id.forDollars);
        forView.setText(curr + "");
       name.setText(currName);
       usCurr.setText("USD");
       Button btnUS = (Button) findViewById(R.id.FromUSD);
       btnUS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               double number = Double.parseDouble(usView.getText().toString());
               double usNum = findForConversion(number, curr);
               forView.setText(String.format("%.2f", usNum));

           }
       });
       Button btnFR = (Button) findViewById(R.id.ToUSD);
        btnFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number = Double.parseDouble(forView.getText().toString());
                double usNum = findUSConversion(number, curr);
                usView.setText(String.format("%.2f", usNum));


            }
        });


    }

    private double findUSConversion(double number, double curr) {
        double result = 0.0;

        result = number / curr;

        return result;
    }

    private double findForConversion(double number, double curr) {
        double result = 0.0;

        result = number * curr;

        return result;
    }


    public void Onback (View v){

        finish();

    }
}