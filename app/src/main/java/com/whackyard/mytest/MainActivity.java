package com.whackyard.mytest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void doIntnt(View view){
        switch (view.getId()){

            case R.id.imgBtnSMS:
                Intent sms = new Intent(this, Messenger.class);
                startActivity(sms);
                break;
            case R.id.imgBtnGreet:
                Intent grt = new Intent(this, GreetUserActivity.class);
                startActivity(grt);
                break;
            case R.id.imgBtnCalc:
                Intent calc = new Intent(this, CalculatorActivity.class);
                startActivity(calc);
                break;
            case R.id.imgBtnBench:
                Intent bench = new Intent(this, BenchmarkActivity.class);
                startActivity(bench);
                break;
            case R.id.imgBtnVibr:
                Intent vib = new Intent(this, Massage.class);
                startActivity(vib);
                break;
            case R.id.btnWeb:
                Intent web = new Intent(this, WebViewZ.class);
                startActivity(web);
                break;
            case R.id.imageButton:
                Intent frameWeb = new Intent(this, WebViewZ.class);
                startActivity(frameWeb);
                break;
            case R.id.imgBtnNotific:
                Intent notifyImg = new Intent(this, NotificationManActivity.class);
                startActivity(notifyImg);
                break;
            case R.id.btnNotific:
                Intent notify = new Intent(this, NotificationManActivity.class);
                startActivity(notify);
                break;
            case R.id.imgBtnFelight:
                Intent fel = new Intent(this, NewsActivity.class);
                fel.setType("text/plain");
                fel.putExtra(android.content.Intent.EXTRA_TEXT, "Felight News");
                startActivity(fel);
                break;
            case R.id.imgBtnMusicPly:
                Intent musicPly = new Intent(this, AudioPlayerActivity.class);
                startActivity(musicPly);
                break;
            case R.id.imgBtnPopUp:
                Intent noPop = new Intent(this, PopUpActivity.class);
                startActivity(noPop);
                break;
            case R.id.imgBtnVdo:
                Intent vidPly = new Intent(this, VideoPlayerActivity.class);
                startActivity(vidPly);
                break;
            case R.id.imgBtnAnim:
                Intent animation = new Intent(this, AnimationActivity.class);
                startActivity(animation);
                break;
            case R.id.btnUserReg:
                Intent reg = new Intent(this, UserRegActivity.class);
                startActivity(reg);
                break;
        }

    }

}
