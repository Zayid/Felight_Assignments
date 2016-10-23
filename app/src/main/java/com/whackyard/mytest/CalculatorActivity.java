package com.whackyard.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nazila on 12/10/2016.
 */

public class CalculatorActivity extends AppCompatActivity {

    private static final String TAG = CalculatorActivity.class.getSimpleName();
    private EditText num1;
    private EditText num2;
    private TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = (EditText) findViewById(R.id.etNum1);
        num2 = (EditText) findViewById(R.id.etNum2);
        result = (TextView) findViewById(R.id.tvResult);
        result.setVisibility(View.INVISIBLE);

    }

    public void doCalc(View view)
    {
        Log.i(TAG,"Inside doCalc Method");
        result.setVisibility(View.VISIBLE);
        double number1 =0;

        try {
            number1 = Double.parseDouble(num1.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("Please Enter Num1");
            return;
        }

        double number2 =0;
        try {
            number2 = Double.parseDouble(num2.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("Please Enter Num2");
            return;
        }


        switch(view.getId())
        {
            case R.id.btnAdd:
                result.setText(""+(number1+number2));
                Toast.makeText(getBaseContext(),"Addition Performed",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Addition Performed");
                break;

            case R.id.btnSub:
                result.setText(""+(number1-number2));
                Toast.makeText(getBaseContext(),"Subtraction Performed",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Subtraction Performed");
                break;

            case R.id.btnMul:
                result.setText(""+(number1*number2));
                Toast.makeText(getBaseContext(),"Multiplication Performed",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Multiplication Performed");
                break;
            case R.id.btnDiv:
                result.setText(""+(number1/number2));
                Toast.makeText(getBaseContext(),"Division Performed",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Division Performed");
                break;
        }

    }
}
