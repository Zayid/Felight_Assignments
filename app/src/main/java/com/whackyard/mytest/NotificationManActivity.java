package com.whackyard.mytest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotificationManActivity extends AppCompatActivity {

    private int count;
    private EditText nmber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_man);
        nmber = (EditText) findViewById(R.id.etNotifyCount);
    }

    public void createNotification(View view) {
        // Prepare intent which is triggered if the notification is selected
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Parsing the count to Integer
        try {
            count = Integer.parseInt(nmber.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(),"Enter a F***NG number ",Toast.LENGTH_LONG).show();
        }

        // Build notification
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Z Video Player")
                .setContentText("Checkout the new funny videos").setSmallIcon(R.drawable.vector_drawable_ic_play_arrow_black___px)
                .setContentIntent(pIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        for(int i=0;i<count;i++) {
            notificationManager.notify(i, noti);
        }
    }

}
