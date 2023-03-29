package com.student.greentrail.ui.plants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PlantsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Plant fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}