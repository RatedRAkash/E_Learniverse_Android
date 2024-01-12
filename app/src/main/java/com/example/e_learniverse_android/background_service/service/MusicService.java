package com.example.e_learniverse_android.background_service.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;


//Manifest ee SERVICE class Declare kora lagbe
public class MusicService extends Service {
    MediaPlayer myMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null; //Bounded Service er jonno ei Method use hui, Bounded Service mane, jei Service er sathe User Interact korte parbe
    }


    //TODO: APP jotokkon BACKGROUND ee totokkon SERVICE cholbe, APP Background theke Destroy korle Service OFF

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myMediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        myMediaPlayer.setLooping(true);
        myMediaPlayer.start();


//        return super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY; //Service FINISH howar por oo Service jeno DESTROY takhe orhtat OS er sathe NOT_STICKY takhe
    }

    @Override
    public void onDestroy() { //onDestroy amra Manually oo chalaite pari or ANDROID OS MANAGER nijei Service Kill korar jonno ei Method Call dite pare
        myMediaPlayer.stop();

        super.onDestroy();
    }
}
