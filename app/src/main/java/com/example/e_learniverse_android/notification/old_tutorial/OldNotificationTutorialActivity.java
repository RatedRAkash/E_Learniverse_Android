package com.example.e_learniverse_android.notification.old_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.custom_application.CustomApplication;

public class OldNotificationTutorialActivity extends AppCompatActivity {

    private Button buttonTriggerNotification, buttonCancel, buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_notification_tutorial);

        buttonTriggerNotification = (Button) findViewById(R.id.buttonTriggerNotification);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

        buttonTriggerNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CustomApplication)getApplication()).triggerNotificationWithBackStack(NotificationDetailsActivity.class,
                        getString(R.string.NEWS_CHANNEL_ID),
                        "Sample Notification",
                        "This is a sample notification app",
                        "This is a sample notification created by Codetutor for demonstration of how to trigger notifications in Android app ",
                        NotificationCompat.PRIORITY_HIGH,
                        true,
                        getResources().getInteger(R.integer.notificationId),
                        PendingIntent.FLAG_UPDATE_CURRENT);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CustomApplication)getApplication()).cancelNotification(getResources().getInteger(R.integer.notificationId));
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CustomApplication)getApplication()).updateNotification(NotificationDetailsActivity.class,
                        "Updated Notification",
                        "This is updatedNotification",
                        getString(R.string.NEWS_CHANNEL_ID),
                        getResources().getInteger(R.integer.notificationId),
                        "This is a updated information for bigpicture String",
                        PendingIntent.FLAG_UPDATE_CURRENT);
            }
        });
    }
}