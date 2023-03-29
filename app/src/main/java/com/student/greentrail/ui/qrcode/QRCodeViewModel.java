package com.student.greentrail.ui.qrcode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QRCodeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QRCodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is qrcode fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}