package com.whackyard.mytest;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;

public class AudioPlayerActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private MediaPlayer mLinkPlayer;
    private MediaPlayer mPlayerSD;

    private Button btnP1;
    private Button btnP2;

    private RadioButton radioButton;
    private RadioGroup radioGroup;

    private WifiManager wifi;
    private CardView cardView;
    private ToggleButton tBtnWifi;
    private int flag=1;
    private int flagSD=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        btnP1 = (Button) findViewById(R.id.btnPl);
        btnP2 = (Button) findViewById(R.id.btnPs);

        wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        cardView = (CardView) findViewById(R.id.cvWifi);
        tBtnWifi = (ToggleButton) findViewById(R.id.toggleButton);

        mPlayer = MediaPlayer.create(AudioPlayerActivity.this, R.raw.glad_to_be_alone);
        mLinkPlayer = new MediaPlayer();
        mPlayerSD = new MediaPlayer();

        mLinkPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mLinkPlayer.setDataSource("http://fun.2mrbnehb1rrrkme.netdna-cdn.com/funarea/ringtones/Nexus-6P-Ringtone-2014-funonsite.com.mp3");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {

        radioGroup = (RadioGroup) findViewById(R.id.rGrpMusic);
        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                switch (radioButton.getId()){
                    case R.id.rBtnRaw:
                        mPlayer.start();
                        btnP1.setVisibility(View.GONE);
                        btnP2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnStream:
                        if (flag ==1 && !wifi.isWifiEnabled()){
                            wifi.setWifiEnabled(true);
                            wifi.startScan();
                            cardView.setVisibility(View.VISIBLE);
                            flag++;
                        }

                        if(flag==1 && wifi.setWifiEnabled(true)) {
                            try {
                                mLinkPlayer.prepare();
                                flag+=5;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if(flag == 2){
                            try {
                                mLinkPlayer.prepare();
                                flag++;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        mLinkPlayer.start();
                        btnP1.setVisibility(View.GONE);
                        btnP2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnSD:
                        if(flagSD==1) {
                            Intent intent_upload = new Intent();
                            intent_upload.setType("audio/*");
                            intent_upload.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(intent_upload, 1);
                            flagSD++;
                        }
                        else
                        mPlayerSD.start();
                        btnP1.setVisibility(View.GONE);
                        btnP2.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });


        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioButton.getId()){
                    case R.id.rBtnRaw:
                        mPlayer.pause();
                        btnP2.setVisibility(View.GONE);
                        btnP1.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnStream:
                        mLinkPlayer.pause();
                        btnP2.setVisibility(View.GONE);
                        btnP1.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnSD:
                        mPlayerSD.pause();
                        btnP2.setVisibility(View.GONE);
                        btnP1.setVisibility(View.VISIBLE);
                        break;

                }


            }
        });

        tBtnWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    wifi.setWifiEnabled(true);
                    wifi.startScan();
                } else {
                    wifi.setWifiEnabled(false);
                }
            }
        });

        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode == 1){

            if(resultCode == RESULT_OK){

                Uri uri = data.getData();

                try {
                    mPlayerSD.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mPlayerSD.setDataSource(getApplicationContext(),uri);
                    mPlayerSD.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mPlayerSD.start();
                //btnP1.setVisibility(View.GONE);
                //btnP2.setVisibility(View.VISIBLE);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onDestroy() {

        mPlayer.stop();
        mLinkPlayer.stop();
        mPlayerSD.stop();
        super.onDestroy();

    }


}
