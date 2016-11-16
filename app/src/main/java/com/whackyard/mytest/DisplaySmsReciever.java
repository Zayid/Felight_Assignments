package com.whackyard.mytest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class DisplaySmsReciever extends BroadcastReceiver  {
    public DisplaySmsReciever() {
    }

    final SmsManager sms = SmsManager.getDefault();
    private String message;
    private String senderNum;
    public static String msg;

    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();

                    Toast.makeText(context, "Sender : "+ senderNum + ", Message: " + message, Toast.LENGTH_LONG).show();

                    msg = message;

                    context.startService(new Intent(context, SmsReadService.class));

                }
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);


        }
    }

}
