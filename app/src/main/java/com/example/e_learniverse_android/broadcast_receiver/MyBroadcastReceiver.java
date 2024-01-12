package com.example.e_learniverse_android.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer myMediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        myMediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);

        myMediaPlayer.setLooping(true);
        myMediaPlayer.start();
    }
}
