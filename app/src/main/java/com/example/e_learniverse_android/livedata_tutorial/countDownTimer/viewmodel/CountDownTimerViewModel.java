package com.example.e_learniverse_android.livedata_tutorial.countDownTimer.viewmodel;

import android.app.Application;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by AnantaAkashPodder on 25/12/2023.
 */
public class CountDownTimerViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> seconds_livedata = new MutableLiveData<>();
    private MutableLiveData<Boolean> finished_livedata = new MutableLiveData<>();

    public CountDownTimerViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Integer> getSeconds_livedata() {
        return seconds_livedata;
    }

    public MutableLiveData<Boolean> getFinished_livedata() {
        return finished_livedata;
    }

    public void startCounter(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished / 1000;

                // setting the count value
                seconds_livedata.setValue((int) time);
            }

            public void onFinish() {
                finished_livedata.setValue(true);
            }

        }.start();
    }
}
