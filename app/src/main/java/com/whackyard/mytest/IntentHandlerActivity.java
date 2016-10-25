package com.whackyard.mytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import static com.whackyard.mytest.R.id.imageView;

public class IntentHandlerActivity extends AppCompatActivity {

    private Intent intent;
    private ImageView imgIntnt;
    private ImageView mGrayScale;
    private ImageView mBlur;
    private ImageView mSnow;
    private ImageView mBright;
    private ImageView mReflct;
    private ImageView mDark;
    private ImageView mThumb;

    private Bitmap bmGry;
    private Bitmap bmBlur;
    private Bitmap bmSnow;
    private Bitmap bmBrgt;
    private Bitmap bmDrk;
    private Bitmap bmRef;

    private InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_handler);
        imgIntnt = (ImageView) findViewById(R.id.ivInt);
        mGrayScale = (ImageView) findViewById(R.id.ivFilter1);
        mBlur =(ImageView) findViewById(R.id.ivFilter2);
        mSnow = (ImageView) findViewById(R.id.ivFilter3);
        mBright = (ImageView) findViewById(R.id.ivFilter4);
        mReflct = (ImageView) findViewById(R.id.ivFilter5);
        mDark = (ImageView) findViewById(R.id.ivFilter6);
        mThumb = (ImageView) findViewById(R.id.ivInt);


        intent = getIntent();

    }

    @Override
    protected void onStart() {

        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {

            try {
                is = getContentResolver().openInputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Bitmap bmCompressed = BitmapFactory.decodeStream(is);
            Bitmap resized = Bitmap.createScaledBitmap(bmCompressed,(int)(bmCompressed.getWidth()*0.1),(int)(bmCompressed.getHeight()*0.1),true);
            //mThumb.setImageBitmap(resized);
            //imgIntnt.setImageBitmap(BitmapFactory.decodeStream(is));
            imgIntnt.setImageBitmap(resized);
        }

   /*     mGrayScale.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable abmp = (BitmapDrawable)mGrayScale.getDrawable();
        bmGry = abmp.getBitmap();
        mGrayScale.setImageBitmap(ImageProcessing.doGreyscale(bmGry));

        mBlur.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable bmDrBlr = (BitmapDrawable)mBlur.getDrawable();
        bmBlur = bmDrBlr.getBitmap();
        mBlur.setImageBitmap(ImageProcessing.applyGaussianBlur(bmBlur));

        mSnow.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable bmDrSnw = (BitmapDrawable)mSnow.getDrawable();
        bmSnow = bmDrSnw.getBitmap();
        mSnow.setImageBitmap(ImageProcessing.applySnowEffect(bmSnow));

        mBright.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable bmDrBrght = (BitmapDrawable)mBright.getDrawable();
        bmBrgt = bmDrBrght.getBitmap();
        mBright.setImageBitmap(ImageProcessing.doBrightness(bmBrgt));

        mReflct.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable bmDrRef = (BitmapDrawable)mReflct.getDrawable();
        bmRef = bmDrRef.getBitmap();
        mReflct.setImageBitmap(ImageProcessing.applyReflection(bmRef));

        mDark.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable bmDrDrk = (BitmapDrawable)mDark.getDrawable();
        bmDrk = bmDrDrk.getBitmap();
        mDark.setImageBitmap(ImageProcessing.doDark(bmDrk));

*/
        super.onStart();
    }

    public void applyFilter(View view){
        switch (view.getId()){
            case R.id.ivFilter1:
                imgIntnt.setImageBitmap(ImageProcessing.doGreyscale(bmGry));
                break;
            case R.id.ivFilter2:
                imgIntnt.setImageBitmap(ImageProcessing.applyGaussianBlur(bmBlur));
                break;
            case R.id.ivFilter3:
                imgIntnt.setImageBitmap(ImageProcessing.applySnowEffect(bmSnow));
                break;
            case R.id.ivFilter4:
                imgIntnt.setImageBitmap(ImageProcessing.doBrightness(bmBrgt));
                break;
            case R.id.ivFilter5:
                imgIntnt.setImageBitmap(ImageProcessing.applyReflection(bmRef));
                break;
            case R.id.ivFilter6:
                imgIntnt.setImageBitmap(ImageProcessing.doDark(bmDrk));
                break;

        }
    }


}
