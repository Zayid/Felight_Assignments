package com.whackyard.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView imgLiya;
    Animation animMove;
    Animation animSlide;
    Animation animFadeIn;
    Animation animZmIn;
    Animation animZmOt;
    Animation animRotate;
    Animation animMix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imgLiya = (ImageView) findViewById(R.id.ivLiya);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animZmIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        animZmOt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
        animMix = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mix_anim);
    }

    public void doAnimate(View view){
        switch(view.getId()){
            case R.id.btnRotation:
                imgLiya.startAnimation(animRotate);
                break;
            case R.id.btnZmIn:
                imgLiya.startAnimation(animZmIn);
                break;
            case R.id.btnZmOt:
                imgLiya.startAnimation(animZmOt);
                break;
            case R.id.btnAlpha:
                imgLiya.startAnimation(animFadeIn);
                break;
            case R.id.btnMove:
                imgLiya.startAnimation(animMove);
                break;
            case R.id.btnSlide:
                imgLiya.startAnimation(animSlide);
                break;
            case R.id.btnMix:
                imgLiya.startAnimation(animMix);
                break;
        }
    }
}
