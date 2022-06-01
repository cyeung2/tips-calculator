package com.example.tipscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{


    RadioGroup tipAmountty;

    EditText billTotal, peopleNum;
    TextView tippy, totally, totalPersons, overages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextEdit
        billTotal = findViewById(R.id.billTotal);
        peopleNum = findViewById(R.id.peopleNum);
        tippy = findViewById(R.id.tip);
        totally = findViewById(R.id.total);
        totalPersons = findViewById(R.id.totalPerson);
        overages = findViewById(R.id.overage);


        //RadioGroup
        tipAmountty = findViewById(R.id.tipAmount);

    }

        public void calculateTotalBill(View v){

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);

        double number =  Double.parseDouble(billTotal.getText().toString());
            if (v.getId() == R.id.twelve){
                totally.setText(String.valueOf(df.format(number*1.12)));
                tippy.setText(String.valueOf(df.format(number*0.12)));
            }
            else if (v.getId() == R.id.fiftheen){
                totally.setText(String.valueOf(df.format(number*1.15)));
                tippy.setText(String.valueOf(df.format(number*0.15)));
            }
            else if (v.getId() == R.id.eighteen){
                totally.setText(String.valueOf(df.format(number*1.18)));
                tippy.setText(String.valueOf(df.format(number*0.18)));
            }
            else if (v.getId() == R.id.twenty){
                totally.setText(String.valueOf(df.format(number*1.2)));
                tippy.setText(String.valueOf(df.format(number*0.2)));
            }
        }

        public void clearEverything(View v){
            billTotal.getText().clear();
            peopleNum.getText().clear();
            tippy.setText("");
            totally.setText("");
            totalPersons.setText("");
            overages.setText("");
            tipAmountty.clearCheck();
        }

        public void peopleSplit(View v){
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.UP);
            int pplAmt = Integer.parseInt(peopleNum.getText().toString());
            double number =  Double.parseDouble(totally.getText().toString());
            double roundOff = Double.parseDouble(df.format(number/pplAmt));
            double tmp = Double.parseDouble(df.format(roundOff*pplAmt - number));
            totalPersons.setText(String.valueOf(roundOff));
            overages.setText(String.valueOf(tmp));
        }
}