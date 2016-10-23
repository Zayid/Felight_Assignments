package com.whackyard.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Nazila on 18/10/2016.
 */

public class ActivityLifecycleActivity extends AppCompatActivity {

    String log = "Android : ";
    private TextView tvLog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_android);
        tvLog = (TextView) findViewById(R.id.tvLog);
        Log.d(log," onCreate() called");
        tvLog.setText(" onCreate() called");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(log," onStart() called");
        tvLog.setText(" onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  wait();
        Log.d(log," onPause() called");
        tvLog.setText(" onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(log," onStop() called");
        tvLog.setText(" onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(log," onDestroy() called");
        tvLog.setText(" onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(log," onRestart() called");
    }
}
