package com.example.e_learniverse_android.notification.new_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_learniverse_android.R;

public class NewNotificationTutorialActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "RMA Channel";
    private static final int NOTIFICATION_ID = 14;
    private Button btnCreateNotification;
    private TextView tvNotificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notification_tutorial);

        btnCreateNotification = (Button)findViewById(R.id.btnCreateNotificationId);
        tvNotificationId = (TextView)findViewById(R.id.tvNotificationId);

        Drawable noti_large_drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_icon_large, null);
        BitmapDrawable notiLargeBitmapDrawable = (BitmapDrawable) noti_large_drawable;
        Bitmap notiLargeBitmap = notiLargeBitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification rmaNotification;

        //Android-8(OREA) theke beshi hole we can use "ChannelId" feature
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            rmaNotification = new Notification.Builder(this)
                    .setLargeIcon(notiLargeBitmap)
                    .setSmallIcon(R.drawable.ic_e_learniverse)
                    .setContentText("Real Madrid Message")
                    .setSubText("This subtext for Real Madrid")
                    .setChannelId(CHANNEL_ID)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "RMA New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            rmaNotification = new Notification.Builder(this)
                    .setLargeIcon(notiLargeBitmap)
                    .setSmallIcon(R.drawable.ic_e_learniverse)
                    .setContentText("Real Madrid Message less than Android Orea")
                    .setSubText("This subtext for Real Madrid")
                    .build();
        }


        //TODO: NOTIFICATION_ID is used if we want to append existing Notificaiton after it was Pushed... we can append it by just calling Notify method with the same NOTIFICATION_ID
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, rmaNotification);
                tvNotificationId.setText("Notified Notification");
            }
        });
    }
}