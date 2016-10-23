package com.whackyard.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Nazila on 17/10/2016.
 */

public class ToastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_toast);
        super.onCreate(savedInstanceState);
    }

    public void  dispToast(View view){
        switch (view.getId()){
            case R.id.btnTL:
                Toast t1 =Toast.makeText(ToastActivity.this,"Top Left",Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.TOP|Gravity.LEFT,-35,150);
                t1.show();
                break;
            case R.id.btnTC:
                Toast t2 =Toast.makeText(ToastActivity.this,"Top Center",Toast.LENGTH_SHORT);
                t2.setGravity(Gravity.TOP|Gravity.CENTER,-5,150);
                t2.show();
                break;
            case R.id.btnTR:
                Toast t3 =Toast.makeText(ToastActivity.this,"Top Right",Toast.LENGTH_SHORT);
                t3.setGravity(Gravity.TOP|Gravity.RIGHT,-5,150);
                t3.show();
                break;
            case R.id.btnCL:
                Toast t4 =Toast.makeText(ToastActivity.this,"Center Left",Toast.LENGTH_SHORT);
                t4.setGravity(Gravity.CENTER|Gravity.LEFT,-35,30);
                t4.show();
                break;
            case R.id.btnCC:
                Toast t5 =Toast.makeText(ToastActivity.this,"Center Center",Toast.LENGTH_SHORT);
                t5.setGravity(Gravity.CENTER|Gravity.CENTER,-5,30);
                t5.show();
                break;
            case R.id.btnCR:
                Toast t6 =Toast.makeText(ToastActivity.this,"Center Right",Toast.LENGTH_SHORT);
                t6.setGravity(Gravity.CENTER|Gravity.RIGHT,-5,30);
                t6.show();
                break;
            case R.id.btnBL:
                Toast t7 =Toast.makeText(ToastActivity.this,"Bottom Left",Toast.LENGTH_SHORT);
                t7.setGravity(Gravity.BOTTOM|Gravity.LEFT,-35,85);
                t7.show();
                break;
            case R.id.btnBC:
                Toast t8 =Toast.makeText(ToastActivity.this,"Bottom Center",Toast.LENGTH_SHORT);
                t8.setGravity(Gravity.BOTTOM|Gravity.CENTER,-5,85);
                t8.show();
                break;
            case R.id.btnBR:
                Toast t9 =Toast.makeText(ToastActivity.this,"Bottom Right",Toast.LENGTH_SHORT);
                t9.setGravity(Gravity.BOTTOM|Gravity.RIGHT,-5,85);
                t9.show();
                break;

        }
    }
}
