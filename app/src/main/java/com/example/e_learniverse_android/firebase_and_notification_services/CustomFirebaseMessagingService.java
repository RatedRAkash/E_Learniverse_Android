package com.example.e_learniverse_android.firebase_and_notification_services;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by AnantaAkashPodder on 7/6/2023.
 */
public class CustomFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = CustomFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.d(TAG,"New Token: " +s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG,"Message Received");
    }
}
