package com.example.e_learniverse_android;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.e_learniverse_android.custom_application.CustomApplication;
import com.example.e_learniverse_android.dto.RegisteredAndroidUser;
import com.example.e_learniverse_android.retrofit.ApiServiceInterface;
import com.example.e_learniverse_android.retrofit.RetrofitClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import androidx.core.app.NotificationCompat;

import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button buttonTriggerNotification, buttonCancel, buttonUpdate, registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Analytics
        FirebaseApp.initializeApp(this);

        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d("FCM-Token", token);

        buttonTriggerNotification = (Button)findViewById(R.id.buttonTriggerNotification);
        buttonCancel = (Button)findViewById(R.id.buttonCancel);
        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        registerUser = (Button)findViewById(R.id.registerUser);

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

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterUserActivity.class));
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