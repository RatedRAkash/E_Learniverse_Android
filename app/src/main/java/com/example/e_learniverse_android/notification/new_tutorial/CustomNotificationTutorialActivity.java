package com.example.e_learniverse_android.notification.new_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_learniverse_android.MainActivity;
import com.example.e_learniverse_android.R;


public class CustomNotificationTutorialActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Sergio-Ramos Custom Channel";
    private static final int NOTIFICATION_ID = 4;
    private static final int REQ_CODE = 102;

    private NotificationManager notificationManager;


    private Button btnBigPictureStyle, btnInboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_notification_tutorial);


        btnBigPictureStyle = (Button) findViewById(R.id.btnBigPictureStyle);
        btnInboxStyle = (Button) findViewById(R.id.btnInboxStyle);


        Drawable noti_large_drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_icon_large, null);
        BitmapDrawable notiLargeBitmapDrawable = (BitmapDrawable) noti_large_drawable;
        Bitmap notiLargeBitmap = notiLargeBitmapDrawable.getBitmap();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //bigPictureStyle
        Notification.BigPictureStyle bigPictureStyle =
                new Notification.BigPictureStyle()
                            .bigPicture(((BitmapDrawable)ResourcesCompat.getDrawable(getResources(), R.drawable.sergio_ramos, null)).getBitmap())
                            .setBigContentTitle("Sergio Ramos Big Content Title")
                            .setSummaryText("Sergio Ramos Summary Text");


        //bigPictureStyle
        Notification.InboxStyle inboxStyle =
                new Notification.InboxStyle()
                        .addLine("Sergio Ramos")
                        .addLine("is")
                        .addLine("the")
                        .addLine("best")
                        .addLine("defender")
                        .addLine("of")
                        .addLine("all")
                        .addLine("Time")
                        .setBigContentTitle("Sergio Ramos Inbox Style Content Title")
                        .setSummaryText("Sergio Ramos Inbox Style Summary Text");

        Notification bigPictureStyleNotification = createCustomNotification(notiLargeBitmap, bigPictureStyle, MainActivity.class);
        Notification inboxStyleNotification = createCustomNotification(notiLargeBitmap, inboxStyle, NewNotificationTutorialActivity.class);


        //TODO: NOTIFICATION_ID is used if we want to append existing Notificaiton after it was Pushed... we can append it by just calling Notify method with the same NOTIFICATION_ID
        btnBigPictureStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, bigPictureStyleNotification);
            }
        });

        btnInboxStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, inboxStyleNotification);
            }
        });

    }

    private Notification createCustomNotification(Bitmap notiLargeBitmap, Notification.Style style, Class<?> destinationClass) {

        //Notification ee Tap korle Kon Jaigai niye jabe shei Class er Name
        Intent normalIntent = new Intent(getApplicationContext(),destinationClass);
        normalIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE, normalIntent, PendingIntent.FLAG_UPDATE_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT ---> jodi Already jei Activity te asi, shei Activity tei Land kore, taile jeno oi CURRENT Activity er Multiple instance Nah hui shei jonno ei FLAG

        Notification sergioRamosNotification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            sergioRamosNotification = new Notification.Builder(this)
                    .setLargeIcon(notiLargeBitmap)
                    .setSmallIcon(R.drawable.ic_e_learniverse)
                    .setContentText("Real Madrid Message")
                    .setSubText("This subtext for Real Madrid")
                    .setContentIntent(pendingIntent) // Notification ee CLICK korle kon Activity te niye or kon Action korbe sheita amra PendingIntent ee dukhai
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(true) // Notification Tap korar por Chole jabe
                    .setStyle(style)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Sergio Ramos New Channel", NotificationManager.IMPORTANCE_HIGH));
        }

        else {
            sergioRamosNotification = new Notification.Builder(this)
                    .setLargeIcon(notiLargeBitmap)
                    .setSmallIcon(R.drawable.ic_e_learniverse)
                    .setContentText("Real Madrid Message less than Android Orea")
                    .setSubText("This subtext for Real Madrid")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true) // Notification Tap korar por Chole jabe
                    .setStyle(style)
                    .build();
        }

        return sergioRamosNotification;
    }
}
