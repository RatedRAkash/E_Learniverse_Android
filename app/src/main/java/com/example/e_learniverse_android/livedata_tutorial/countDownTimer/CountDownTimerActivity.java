package com.example.e_learniverse_android.livedata_tutorial.countDownTimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.livedata_tutorial.countDownTimer.viewmodel.CountDownTimerViewModel;

public class CountDownTimerActivity extends AppCompatActivity {

    private TextView tv_countDownTimer;
    private Button buttonStartTimer;
    private CountDownTimerViewModel countDownTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);

        countDownTimerViewModel = new ViewModelProvider(this).get(CountDownTimerViewModel.class);

        tv_countDownTimer = findViewById(R.id.countDownTimerTextView);
        buttonStartTimer = findViewById(R.id.startTimerButton);

        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: This Starts the CounterDown process which changes LIVEDATA Variable and Observers get Notified.
                countDownTimerViewModel.startCounter();
            }
        });


        // TODO: Observing CounterDown LIVEDATA Variable, When the Variable Changes, we Update the UI
        countDownTimerViewModel.getSeconds_livedata().observe(this, time_in_seconds -> {
            tv_countDownTimer.setText(String.valueOf(time_in_seconds));
        });

        countDownTimerViewModel.getFinished_livedata().observe(this, isFinished -> {
            if(isFinished){
                tv_countDownTimer.setText("Finished");
            }
        });
    }
}