package com.example.dailygym.ui.COVID19;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class COVID19ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public COVID19ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
