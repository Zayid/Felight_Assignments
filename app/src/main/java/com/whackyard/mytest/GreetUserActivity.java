package com.whackyard.mytest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nazila on 12/10/2016.
 */

public class GreetUserActivity extends AppCompatActivity {

    private EditText fName;
    private EditText sName;
    private TextView tvGreet;
    Animation animFade;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_user);

        fName = (EditText) findViewById(R.id.etFname);
        sName = (EditText) findViewById(R.id.etSName);
        tvGreet = (TextView) findViewById(R.id.tvResult);

        animFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        tvGreet.setVisibility(View.INVISIBLE);
    }

    public void doGreet(View view)
    {
        String name1 = fName.getText().toString();
        String name2 = sName.getText().toString();

        tvGreet.setText("Greetings "+name1+" "+name2 );
        tvGreet.setTextSize(30);
        tvGreet.setTextColor(Color.BLUE);
        tvGreet.setVisibility(View.VISIBLE);
        tvGreet.startAnimation(animFade);
    }
}
