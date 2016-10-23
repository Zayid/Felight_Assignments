package com.whackyard.mytest;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nazila on 18/10/2016.
 */

public class ContextActivity extends AppCompatActivity {

    Button btnColor;
    final CharSequence[] items = {"Red", "Green", "Blue", "Yellow"};
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        btnColor = (Button) findViewById(R.id.btnContext);
        builder = new AlertDialog.Builder(this);
    }

    public void doContext(View view) {
        builder.setTitle("Pick a color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (items[item] == "Red") {
                    btnColor.setBackgroundColor(Color.RED);
                }
                if (items[item] == "Green") {
                    btnColor.setBackgroundColor(Color.GREEN);
                }
                if (items[item] == "Blue") {
                    btnColor.setBackgroundColor(Color.BLUE);
                }
                if (items[item] == "Yellow") {
                    btnColor.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
