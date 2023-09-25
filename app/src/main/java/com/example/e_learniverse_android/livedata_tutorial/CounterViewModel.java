package com.example.e_learniverse_android.livedata_tutorial;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.MediatorLiveData;

public class CounterViewModel extends ViewModel {
//    *************************************************************************************
    //    Normal LiveData ---> we can Only Get & Observe Data... amra "Set" korte parbo Nah
    //    MutableLiveData ---> eita amra use kori jate kore Data "Set" korte pari
    //    MediatorLiveData ---> TWO or More MutableLiveData ke Observe korar jonno
//    *************************************************************************************


    // MutableLiveData for counter1 and counter2
    private MutableLiveData<Integer> counter1LiveData;
    private MutableLiveData<Integer> counter2LiveData;

    // MediatorLiveData to observe both counters
    private MediatorLiveData<Integer> combinedMediatorLiveData;

    public MutableLiveData<Integer> getCounter1LiveData() {
        if (counter1LiveData == null) {
            counter1LiveData = new MutableLiveData<>();
            counter1LiveData.setValue(0); // Initialize counter1 with 0
        }
        return counter1LiveData;
    }

    public void incrementCounter1() {
        // Get the current value from the LiveData
        Integer currentValue = counter1LiveData.getValue();
        if (currentValue != null) {
            // Increment the counter
            counter1LiveData.setValue(currentValue + 1);
        }
    }

    public MutableLiveData<Integer> getCounter2LiveData() {
        if (counter2LiveData == null) {
            counter2LiveData = new MutableLiveData<>();
            counter2LiveData.setValue(0); // Initialize counter2 with 0
        }
        return counter2LiveData;
    }

    public void incrementCounter2() {
        // Get the current value from the LiveData
        Integer currentValue = counter2LiveData.getValue();
        if (currentValue != null) {
            // Increment the counter
            counter2LiveData.setValue(currentValue + 1);
        }
    }

    public MediatorLiveData<Integer> getCombinedMediatorLiveData() {
        if (combinedMediatorLiveData == null) {
            combinedMediatorLiveData = new MediatorLiveData<>();
            // Add both counters as sources for the MediatorLiveData
            combinedMediatorLiveData.addSource(counter1LiveData, value -> updateCombinedCounter());
            combinedMediatorLiveData.addSource(counter2LiveData, value -> updateCombinedCounter());
        }
        return combinedMediatorLiveData;
    }

    // Function to update the combined counter value
    private void updateCombinedCounter() {
        Integer count1 = counter1LiveData.getValue();
        Integer count2 = counter2LiveData.getValue();
        if (count1 != null && count2 != null) {
            // Calculate the combined counter value (e.g., sum of both counters)
            int combinedCount = count1 + count2;
            combinedMediatorLiveData.setValue(combinedCount);
        }
    }
}
