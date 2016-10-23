package com.whackyard.mytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Nazila on 17/10/2016.
 */

public class Massage extends AppCompatActivity {

    private FloatingActionButton fab;
    private Vibrator vibrator;
    private Button btMoon;
    private Button btEarth;
    private Button btSun;

    Animation animMove;
    Animation animSlide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);

        animMove = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);

        btMoon = (Button)findViewById(R.id.btnMoon);
        btEarth = (Button)findViewById(R.id.btnEarth);
        btSun = (Button)findViewById(R.id.btnSun);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
            }
        });

        btMoon.startAnimation(animMove);
        btEarth.startAnimation(animMove);
        btSun.startAnimation(animMove);

        fab.startAnimation(animSlide);

    }

    public void doVibrate(View view){
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        long moon[]={0,300,300,300,300,300,300};
        long earth[]={0,300,100,300,100,300,100};
        long sun[]={0,100,100,100,100,100,100,100};
        switch(view.getId()){
            case R.id.btnMoon:
                vibrator.vibrate(moon, 0);
                break;
            case R.id.btnEarth:
                vibrator.vibrate(earth, 0);
                break;

            case R.id.btnSun:
                vibrator.vibrate(sun, 0);
                break;

        }

    }

}
