package com.example.e_learniverse_android.livedata_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import com.example.e_learniverse_android.R;

public class LiveDataTutorialActivity extends AppCompatActivity {

    private Button buttonCounter1, buttonCounter2;
    private TextView tv_counter1, tv_counter2, tv_combined_counter;
    private CounterViewModel counterViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata_tutorial);

        counterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        buttonCounter1 = (Button)findViewById(R.id.buttonCounter1);
        tv_counter1 = (TextView) findViewById(R.id.textCounter1);

        buttonCounter2 = (Button)findViewById(R.id.buttonCounter2);
        tv_counter2 = (TextView) findViewById(R.id.textCounter2);

        tv_combined_counter = (TextView) findViewById(R.id.tv_combined_counter_id);

        counterViewModel.getCounter1LiveData().observe(this, count -> {
            tv_counter1.setText(String.valueOf(count));
            updateCombinedCounter();
        });

        counterViewModel.getCounter2LiveData().observe(this, count -> {
            tv_counter2.setText(String.valueOf(count));
            updateCombinedCounter();
        });

        counterViewModel.getCombinedMediatorLiveData().observe(this, combinedCount -> {
            tv_combined_counter.setText(String.valueOf(combinedCount));
        });

        buttonCounter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the ViewModel function to increment the counter
                counterViewModel.incrementCounter1();
                Toast toast = Toast.makeText(getApplicationContext(),"Counter1: "+counterViewModel.getCounter1LiveData().getValue(),Toast. LENGTH_SHORT);
                toast.show();
            }
        });

        buttonCounter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterViewModel.incrementCounter2();
                Toast toast = Toast.makeText(getApplicationContext(),"Counter2: "+counterViewModel.getCounter2LiveData().getValue(),Toast. LENGTH_SHORT);
                toast.show();
            }
        });
    }
    private void updateCombinedCounter() {
        Integer count1 = counterViewModel.getCounter1LiveData().getValue();
        Integer count2 = counterViewModel.getCounter2LiveData().getValue();
        if (count1 != null && count2 != null) {
            int combinedCount = count1 + count2;
            counterViewModel.getCombinedMediatorLiveData().setValue(combinedCount);
        }
    }
}