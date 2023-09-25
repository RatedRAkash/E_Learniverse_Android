package com.example.e_learniverse_android.livedata_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_learniverse_android.R;

public class LiveDataTutorialActivity extends AppCompatActivity {

    Button buttonCounter1, buttonCounter2;
    TextView tv_counter1, tv_counter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata_tutorial);

        buttonCounter1 = (Button)findViewById(R.id.buttonCounter1);
        tv_counter1 = (TextView) findViewById(R.id.textCounter1);

        buttonCounter2 = (Button)findViewById(R.id.buttonCounter2);
        tv_counter2 = (TextView) findViewById(R.id.textCounter2);
    }
}