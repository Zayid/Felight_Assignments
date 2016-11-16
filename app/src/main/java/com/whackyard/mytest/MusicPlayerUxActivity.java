package com.whackyard.mytest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicPlayerUxActivity extends Activity {

    private LinearLayout mFix;
    private LinearLayout mBurning;
    private LinearLayout mDontLet;
    private LinearLayout mEchoes;
    private LinearLayout mFallingAway;
    private LinearLayout mKeepOn;
    private LinearLayout mLastTo;
    private LinearLayout mPaper;
    private LinearLayout mPeople;
    private LinearLayout mStare;

    private LinearLayout mPlaylist;
    private LinearLayout mNowPlaying;

    private ImageView mAlbumArt;
    private TextView mTitle;
    private TextView mArtist;

    private MediaPlayer mPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_music_player_ux);

        mPlaylist = (LinearLayout) findViewById(R.id.linearPlaylist);
        mNowPlaying = (LinearLayout) findViewById(R.id.linearNowPlaying);

        mFix = (LinearLayout) findViewById(R.id.linearFixYou);
        mBurning = (LinearLayout) findViewById(R.id.linearBurnigBrdg);
        mDontLet = (LinearLayout) findViewById(R.id.linearDontLetMe);
        mEchoes = (LinearLayout) findViewById(R.id.linearEchoes);
        mFallingAway = (LinearLayout) findViewById(R.id.linearFallingAway);
        mKeepOn = (LinearLayout) findViewById(R.id.linearKeepOn);
        mLastTo = (LinearLayout) findViewById(R.id.linearLastToKnow);
        mPaper = (LinearLayout) findViewById(R.id.linearPapercut);
        mPeople = (LinearLayout) findViewById(R.id.linearPeopleAre);
        mStare = (LinearLayout) findViewById(R.id.linearStare);

        mAlbumArt = (ImageView) findViewById(R.id.ivAlbumArt);
        mTitle = (TextView) findViewById(R.id.tvTitle);
        mArtist = (TextView) findViewById(R.id.tvArtist);


    }

    public void rockOn(View v){
        switch (v.getId()){
            case R.id.linearFixYou:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_cold));
                mTitle.setText("Fix You");
                mArtist.setText("Coldplay");
                try {
                    FileDescriptor fd = null;
                    String filename = "/Music/FixYou.mp3";

                        File baseDir = Environment.getExternalStorageDirectory();
                        String audioPath = baseDir.getAbsolutePath() + filename + ".mp3";
                        FileInputStream fis = new FileInputStream(audioPath);
                        fd = fis.getFD();


                    if (fd != null) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(fd);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*try {
                    mPlay.setDataSource("mnt/extSdCard/Music/FixYou.mp3");
                    mPlay.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlay.start();*/
                //mPlay = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/FixYou.mp3"));
                //mPlay.start();
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearBurnigBrdg:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_onerepub));
                mTitle.setText("Burning Bridge");
                mArtist.setText("OneRepublic");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearDontLetMe:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_chain));
                mTitle.setText("Dont Let Me Down");
                mArtist.setText("Chainsmokers");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearEchoes:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_gun));
                mTitle.setText("Echoes");
                mArtist.setText("Young Guns");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearFallingAway:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_muse));
                mTitle.setText("Falling Away With You");
                mArtist.setText("Muse");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearKeepOn:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_tame));
                mTitle.setText("Keep On Lying");
                mArtist.setText("Tame Impala");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearLastToKnow:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_last));
                mTitle.setText("Last To Know");
                mArtist.setText("Three Days Grace");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearPapercut:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_linkin));
                mTitle.setText("Papercut");
                mArtist.setText("Linkin Park");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearPeopleAre:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_the_door));
                mTitle.setText("People Are Strange");
                mArtist.setText("The Doors");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.linearStare:
                mAlbumArt.setImageDrawable(getResources().getDrawable(R.drawable.art_marjor));
                mTitle.setText("Stare");
                mArtist.setText("Marjorie Fair");
                mPlaylist.setVisibility(View.GONE);
                mNowPlaying.setVisibility(View.VISIBLE);
                break;
            case R.id.imgBtnBack:
                mNowPlaying.setVisibility(View.GONE);
                mPlaylist.setVisibility(View.VISIBLE);
                break;

        }
    }
}
