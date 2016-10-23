package com.whackyard.mytest;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

import java.io.IOException;

public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private Uri uri;
    private String uriPath;
    private String uriPathStream;

    private int flag = 1;
    private int flagSD=1;
    private int f = 1;
    private int reset =0;

    private Button btnVdoPly;
    private Button btnVdoPse;

    private RadioButton radioButtonVdo;
    private RadioGroup radioGroupVdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        btnVdoPly = (Button) findViewById(R.id.btnFramePlay);
        btnVdoPse = (Button) findViewById(R.id.btnFramePause);

        uriPath = "android.resource://com.whackyard.mytest/"+R.raw.dude;
        uriPathStream = "http://198.255.98.58/file5/hindi/movie/2016/force_2/Rang%20Laal%20-%20[Webmusic.IN].mp4";

        uri = Uri.parse(uriPath);


    }

    @Override
    protected void onStart() {
        super.onStart();
        radioGroupVdo = (RadioGroup) findViewById(R.id.rBtnGrpVdo);

        btnVdoPly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupVdo.getCheckedRadioButtonId();
                radioButtonVdo = (RadioButton) findViewById(selectedId);

                switch (radioButtonVdo.getId()) {
                    case R.id.rBtnVdoRaw:
                        if(f == 1 || reset ==0) {
                            videoView.setVideoURI(uri);
                            f++;
                            reset=1;
                        }
                        videoView.setMediaController(mediaController);
                        videoView.requestFocus();
                        videoView.start();
                        btnVdoPly.setVisibility(View.INVISIBLE);
                        btnVdoPse.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnVdoLink:
                        if(flag == 1){
                            uri = Uri.parse(uriPathStream);
                            videoView.setVideoURI(uri);
                            flag++;
                        }
                        videoView.setMediaController(mediaController);
                        videoView.requestFocus();
                        videoView.start();
                        btnVdoPly.setVisibility(View.INVISIBLE);
                        btnVdoPse.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnVdoSD:
                        if(flagSD==1 || reset==1) {
                            Intent intent_upload = new Intent();
                            intent_upload.setType("video/*");
                            intent_upload.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(intent_upload, 1);
                            flagSD++;
                            reset=0;
                        }
                        videoView.start();
                        btnVdoPly.setVisibility(View.INVISIBLE);
                        btnVdoPse.setVisibility(View.VISIBLE);
                        videoView.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });

        btnVdoPse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioButtonVdo.getId()){
                    case R.id.rBtnVdoRaw:
                        videoView.pause();
                        btnVdoPse.setVisibility(View.GONE);
                        btnVdoPly.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnVdoLink:
                        videoView.pause();
                        btnVdoPse.setVisibility(View.GONE);
                        btnVdoPly.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rBtnVdoSD:
                        videoView.pause();
                        btnVdoPse.setVisibility(View.GONE);
                        btnVdoPly.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode == 1){

            if(resultCode == RESULT_OK){

                Uri uri = data.getData();

                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();

    }
}
