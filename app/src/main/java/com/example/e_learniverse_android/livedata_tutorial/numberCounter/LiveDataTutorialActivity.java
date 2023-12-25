package com.example.e_learniverse_android.livedata_tutorial.numberCounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_learniverse_android.R;
import com.example.e_learniverse_android.livedata_tutorial.numberCounter.viewmodel.NumberCounterViewModel;

public class LiveDataTutorialActivity extends AppCompatActivity {

    private Button buttonCounter1, buttonCounter2;
    private TextView tv_counter1, tv_counter2, tv_combined_counter;
    private NumberCounterViewModel numberCounterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata_tutorial);

        numberCounterViewModel = new ViewModelProvider(this).get(NumberCounterViewModel.class);

        buttonCounter1 = (Button)findViewById(R.id.buttonCounter1);
        tv_counter1 = (TextView) findViewById(R.id.textCounter1);

        buttonCounter2 = (Button)findViewById(R.id.buttonCounter2);
        tv_counter2 = (TextView) findViewById(R.id.textCounter2);

        tv_combined_counter = (TextView) findViewById(R.id.tv_combined_counter_id);

        numberCounterViewModel.getCounter1LiveData().observe(this, count -> {
            tv_counter1.setText(String.valueOf(count));
            updateCombinedCounter();
        });

        numberCounterViewModel.getCounter2LiveData().observe(this, count -> {
            tv_counter2.setText(String.valueOf(count));
            updateCombinedCounter();
        });

        numberCounterViewModel.getCombinedMediatorLiveData().observe(this, combinedCount -> {
            tv_combined_counter.setText(String.valueOf(combinedCount));
        });

        buttonCounter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the ViewModel function to increment the counter
                numberCounterViewModel.incrementCounter1();
                Toast toast = Toast.makeText(getApplicationContext(),"Counter1: "+ numberCounterViewModel.getCounter1LiveData().getValue(),Toast. LENGTH_SHORT);
                toast.show();
            }
        });

        buttonCounter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberCounterViewModel.incrementCounter2();
                Toast toast = Toast.makeText(getApplicationContext(),"Counter2: "+ numberCounterViewModel.getCounter2LiveData().getValue(),Toast. LENGTH_SHORT);
                toast.show();
            }
        });
    }
    private void updateCombinedCounter() {
        Integer count1 = numberCounterViewModel.getCounter1LiveData().getValue();
        Integer count2 = numberCounterViewModel.getCounter2LiveData().getValue();
        if (count1 != null && count2 != null) {
            int combinedCount = count1 + count2;
            numberCounterViewModel.getCombinedMediatorLiveData().setValue(combinedCount);
        }
    }
}