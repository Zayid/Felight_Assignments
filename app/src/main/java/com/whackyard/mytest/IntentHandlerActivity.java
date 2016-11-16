package com.whackyard.mytest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.frosquivel.magicaltakephoto.MagicalTakePhoto;

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
    private ImageView mTemp;
    private ImageView mCamera;

    private Bitmap bmGry;
    private Bitmap bmBlur;
    private Bitmap bmSnow;
    private Bitmap bmBrgt;
    private Bitmap bmDrk;
    private Bitmap bmRef;

    private MagicalTakePhoto magicalTakePhoto;

    private InputStream is = null;
    private InputStream isX = null;
    //private InputStream isT = null;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgIntnt.setImageBitmap(photo);
            mTemp.setImageBitmap(photo);
            makeThumb(photo);
        }
    }

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
        mThumb = (ImageView) findViewById(R.id.ivTempForThumb);
        mTemp = (ImageView) findViewById(R.id.ivT);
        mCamera = (ImageView) findViewById(R.id.ivCamera);

        magicalTakePhoto =  new MagicalTakePhoto(this,400);

        intent = getIntent();


        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {

            try {
                is = getContentResolver().openInputStream(imageUri);
                isX = getContentResolver().openInputStream(imageUri);
                //isT = getContentResolver().openInputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Bitmap bmCompressed = BitmapFactory.decodeStream(is);
            Bitmap resized = Bitmap.createScaledBitmap(bmCompressed,(int)(bmCompressed.getWidth()*0.5),(int)(bmCompressed.getHeight()*0.5),true);
            imgIntnt.setImageBitmap(resized);
            mTemp.setImageBitmap(resized);
            makeThumb(resized);
        }


        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1);

            }
        });
    }

    private void makeThumb(Bitmap bm) {
        Bitmap resized = Bitmap.createScaledBitmap(bm,(int)(bm.getWidth()*0.1),(int)(bm.getHeight()*0.1),true);
        mThumb.setImageBitmap(resized);

        mGrayScale.setImageDrawable(mThumb.getDrawable());
        mBlur.setImageDrawable(mThumb.getDrawable());
        mDark.setImageDrawable(mThumb.getDrawable());
        mReflct.setImageDrawable(mThumb.getDrawable());
        mBright.setImageDrawable(mThumb.getDrawable());
        mSnow.setImageDrawable(mThumb.getDrawable());

        BitmapDrawable abmp = (BitmapDrawable)mGrayScale.getDrawable();
        bmGry = abmp.getBitmap();
        mGrayScale.setImageBitmap(ImageProcessing.doGreyscale(bmGry));

        BitmapDrawable bmDrBlr = (BitmapDrawable)mBlur.getDrawable();
        bmBlur = bmDrBlr.getBitmap();
        mBlur.setImageBitmap(ImageProcessing.applyGaussianBlur(bmBlur));

        BitmapDrawable bmDrSnw = (BitmapDrawable)mSnow.getDrawable();
        bmSnow = bmDrSnw.getBitmap();
        mSnow.setImageBitmap(ImageProcessing.applySnowEffect(bmSnow));

        BitmapDrawable bmDrBrght = (BitmapDrawable)mBright.getDrawable();
        bmBrgt = bmDrBrght.getBitmap();
        mBright.setImageBitmap(ImageProcessing.doBrightness(bmBrgt));

        BitmapDrawable bmDrRef = (BitmapDrawable)mReflct.getDrawable();
        bmRef = bmDrRef.getBitmap();
        mReflct.setImageBitmap(ImageProcessing.applyReflection(bmRef));

        BitmapDrawable bmDrDrk = (BitmapDrawable)mDark.getDrawable();
        bmDrk = bmDrDrk.getBitmap();
        mDark.setImageBitmap(ImageProcessing.doDark(bmDrk));
    }

    public void applyFilter(View view){
        switch (view.getId()){
            case R.id.ivFilter1:
                BitmapDrawable abmp = (BitmapDrawable)mTemp.getDrawable();
                bmGry = abmp.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.doGreyscale(bmGry));
                break;
            case R.id.ivFilter2:
                BitmapDrawable bmDrBlr = (BitmapDrawable)mTemp.getDrawable();
                bmBlur = bmDrBlr.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.applyGaussianBlur(bmBlur));
                break;
            case R.id.ivFilter3:
                BitmapDrawable bmDrSnw = (BitmapDrawable)mTemp.getDrawable();
                bmSnow = bmDrSnw.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.applySnowEffect(bmSnow));
                break;
            case R.id.ivFilter4:
                BitmapDrawable bmDrBrght = (BitmapDrawable)mTemp.getDrawable();
                bmBrgt = bmDrBrght.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.doBrightness(bmBrgt));
                break;
            case R.id.ivFilter5:
                BitmapDrawable bmDrRef = (BitmapDrawable)mTemp.getDrawable();
                bmRef = bmDrRef.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.applyReflection(bmRef));
                break;
            case R.id.ivFilter6:
                BitmapDrawable bmDrDrk = (BitmapDrawable)mTemp.getDrawable();
                bmDrk = bmDrDrk.getBitmap();
                imgIntnt.setImageBitmap(ImageProcessing.doDark(bmDrk));
                break;

        }
    }


}
