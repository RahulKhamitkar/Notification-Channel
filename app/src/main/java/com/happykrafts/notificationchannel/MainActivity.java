package com.happykrafts.notificationchannel;


import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.happykrafts.notificationchannel.App.*;

public class MainActivity extends AppCompatActivity {

    private EditText mTitle, mMessage;
    private NotificationManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.title);
        mMessage = findViewById(R.id.message);

        mManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }

    public void btnOneClicked(View view) {

        String title = mTitle.getText().toString();
        String message = mMessage.getText().toString();

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,App.CHANNEL_ONE_ID);

        builder.setSmallIcon(R.drawable.ic_one_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        mManager.notify(1,builder.build());

    }

    public void btnTwoClicked(View view){


        String title = mTitle.getText().toString();
        String message = mMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_TWO_ID)
                .setSmallIcon(R.drawable.ic_two_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        mManager.notify(2,notification);

    }
}
