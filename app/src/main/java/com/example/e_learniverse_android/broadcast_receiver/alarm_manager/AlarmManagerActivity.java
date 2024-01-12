package com.example.e_learniverse_android.broadcast_receiver.alarm_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_learniverse_android.R;

public class AlarmManagerActivity extends AppCompatActivity {

    private final int ALARM_REQ_CODE = 6; //Notification er moto REQUEST_CODE lagbe, so that we can identify PendingIntent's UNIQUELY later

    private Button btnStartBroadcastReceiver;
    private EditText editTextViewTime;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        btnStartBroadcastReceiver = (Button) findViewById(R.id.btnStartBroadcastReceiver);
        editTextViewTime = (EditText) findViewById(R.id.timeId);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent normalIntent = new Intent(AlarmManagerActivity.this, MyBroadcastReceiver.class); //means, MyBroadcastReceiver.class START koro
        normalIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQ_CODE, normalIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        btnStartBroadcastReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(editTextViewTime.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000); //miliseconds ke Seconds ee convert korlam 1000 diye Multiple kore
                editTextViewTime.setText("0");

                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            }
        });
    }
}
