package com.example.quizapp2.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    MutableLiveData<String>title = new MutableLiveData<>();

    public void  init(){
        title.setValue("Main activity ");
        Log.d("ololo", "init: ");
    }
    void changeTitle(){
        title.setValue("new title");
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }


}
