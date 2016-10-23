package com.whackyard.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Nazila on 17/10/2016.
 */

public class Messenger extends AppCompatActivity {

    private EditText num;
    private EditText msg;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        num = (EditText) findViewById(R.id.etNumber);
        msg = (EditText) findViewById(R.id.etContent);
        fab = (FloatingActionButton) findViewById(R.id.btnSend);
    }

    public void doSend(View view){
        String number ="";

        try {
            number = num.getText().toString();
        } catch (NumberFormatException e) {
            Toast.makeText(Messenger.this,"Enter the Number Correctly",Toast.LENGTH_LONG).show();
            return;
        }
        String contnd = msg.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, contnd, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }

}
