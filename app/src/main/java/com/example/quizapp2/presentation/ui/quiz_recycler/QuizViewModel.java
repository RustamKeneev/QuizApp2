package com.example.quizapp2.presentation.ui.quiz_recycler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp2.model.Question;

public class QuizViewModel extends ViewModel {

    MutableLiveData<Question> question = new MutableLiveData<>();



    public QuizViewModel() {
    }

}
