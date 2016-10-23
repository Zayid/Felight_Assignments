package com.whackyard.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.button;

/**
 * Created by Nazila on 18/10/2016.
 */

public class NoXmlActivity extends AppCompatActivity {
    private EditText etFName;
    private EditText etSName;
    private Button grt;
    private TextView tvRs;
    private String n1="";
    private String n2="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(0,20,0,0);

        etFName = new EditText(this);
        etFName.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        etFName.setHeight(25);
        etFName.setLayoutParams(layoutParams);
        etFName.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(etFName);

        etSName = new EditText(this);
        etSName.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        etSName.setHeight(25);
        etSName.setLayoutParams(layoutParams);
        etSName.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(etSName);



        grt = new Button(this);
        grt.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        grt.setLayoutParams(layoutParams);
        grt.setLayoutParams(layoutParams);
        grt.setHeight(25);
        grt.setText("Greet Me");
        layout.addView(grt);



        tvRs = new TextView(this);
        tvRs.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        tvRs.setLayoutParams(layoutParams);
        tvRs.setHeight(25);
        tvRs.setVisibility(View.INVISIBLE);
        layout.addView(tvRs);

        grt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                n1 = etFName.getText().toString();
                n2 = etFName.getText().toString();
                tvRs.setText("Greetings "+n1+" "+n2);
                tvRs.setVisibility(View.VISIBLE);
            }

    });
    setContentView(layout);
}
}