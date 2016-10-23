package com.whackyard.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Nazila on 18/10/2016.
 */

public class NewsActivity extends AppCompatActivity {

    private TextView tvNews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        tvNews = (TextView) findViewById(R.id.tvNewsRes);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String value1 = extras.getString(Intent.EXTRA_TEXT);
        if (value1 != null) {
            tvNews.setText(value1);
        }
    }

}
