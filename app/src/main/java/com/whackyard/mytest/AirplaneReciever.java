package com.whackyard.mytest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneReciever extends BroadcastReceiver {
    public AirplaneReciever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // an Intent broadcast.
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            Toast.makeText(context, "Action: AIRPLANE_MODE" , Toast.LENGTH_LONG).show();
        }
    }
}
