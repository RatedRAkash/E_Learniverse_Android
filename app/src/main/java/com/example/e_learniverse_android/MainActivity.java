package com.example.e_learniverse_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.e_learniverse_android.author_third_party_api.AuthorActivity;
import com.example.e_learniverse_android.background_service.MediaPlayerBackgroundActivity;
import com.example.e_learniverse_android.broadcast_receiver.alarm_manager.AlarmManagerActivity;
import com.example.e_learniverse_android.implicit_intent.ImplicitIntentActivity;
import com.example.e_learniverse_android.kotlin_code.KotlinPracticeActivity;
import com.example.e_learniverse_android.livedata_tutorial.countDownTimer.CountDownTimerActivity;
import com.example.e_learniverse_android.livedata_tutorial.numberCounter.LiveDataTutorialActivity;
import com.example.e_learniverse_android.notification.new_tutorial.NewNotificationTutorialActivity;
import com.example.e_learniverse_android.notification.old_tutorial.OldNotificationTutorialActivity;
import com.example.e_learniverse_android.realtime_database.RealTimeDatabaseTutorialActivity;
import com.example.e_learniverse_android.register_user_to_my_backend.RegisterUserActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonOldNotificationTutorial, buttonNewNotificationTutorial, buttonRegisterUser, buttonTutorialLiveData, buttonCallAuthorApi, buttonCountDownTimer, buttonMusicService, buttonBroadcastReceiver, buttonImplicitIntent, buttonRealTimeDatabase, buttonKotlinPracticeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Analytics
        FirebaseApp.initializeApp(this);

        try{
            String token = FirebaseInstanceId.getInstance().getToken();

            Log.d("FCM-Token: ", token);
        }
        catch (Exception e){
            Log.d("FCM-Token Not Found: ", e.toString());
        }

        buttonOldNotificationTutorial = (Button)findViewById(R.id.oldNotificationTutorial);
        buttonNewNotificationTutorial = (Button)findViewById(R.id.newNotificationTutorial);
        buttonRegisterUser = (Button)findViewById(R.id.registerUser);
        buttonTutorialLiveData = (Button)findViewById(R.id.tutorialLiveData);
        buttonCallAuthorApi = (Button)findViewById(R.id.callAuthorApi);
        buttonCountDownTimer = (Button)findViewById(R.id.countDownTimer);
        buttonMusicService = (Button)findViewById(R.id.btnMusicService);
        buttonBroadcastReceiver = (Button)findViewById(R.id.btnBroadcastReceiver);
        buttonImplicitIntent = (Button)findViewById(R.id.btnImplicitIntent);
        buttonRealTimeDatabase = (Button)findViewById(R.id.btnRealTimeDatabaseTutorial);
        buttonKotlinPracticeActivity = (Button)findViewById(R.id.btnKotlinPracticeActivity);

        buttonOldNotificationTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OldNotificationTutorialActivity.class));
            }
        });

        buttonRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterUserActivity.class));
            }
        });

        buttonTutorialLiveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LiveDataTutorialActivity.class));
            }
        });

        buttonCallAuthorApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AuthorActivity.class));
            }
        });

        buttonCountDownTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CountDownTimerActivity.class));
            }
        });

        buttonNewNotificationTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewNotificationTutorialActivity.class));
            }
        });

        buttonMusicService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MediaPlayerBackgroundActivity.class));
            }
        });

        buttonBroadcastReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AlarmManagerActivity.class));
            }
        });

        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImplicitIntentActivity.class));
            }
        });

        buttonRealTimeDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RealTimeDatabaseTutorialActivity.class));
            }
        });

        buttonKotlinPracticeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KotlinPracticeActivity.class));
            }
        });
    }
}


//public class MainActivity extends AppCompatActivity {
//    private static final String TAG = MainActivity.class.getSimpleName();
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
//
//        // Get the FCM token
////        FirebaseInstanceId.getInstance().getToken()
////                .addOnCompleteListener(task -> {
////                    if (!task.isSuccessful()) {
////                        Log.w("FCM Token", "Fetching FCM registration token failed", task.getException());
////                        return;
////                    }
////
////                    // Get the token
////                    String token = task.getResult();
////
////                    // Print/log the token
////                    Log.d("FCM Token", token);
////                });
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "Refreshed token: " + refreshedToken);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}