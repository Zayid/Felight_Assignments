package com.whackyard.mytest;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.whackyard.mytest.R.id.imageView;

public class IntentHandlerActivity extends AppCompatActivity {

    private Intent intent;
    private ImageView imgIntnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_handler);
        imgIntnt = (ImageView) findViewById(R.id.ivInt);
        intent = getIntent();
    }

    @Override
    protected void onStart() {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            InputStream is = null;
            try {
                is = getContentResolver().openInputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imgIntnt.setImageBitmap(BitmapFactory.decodeStream(is));
        }
        super.onStart();
    }
}
