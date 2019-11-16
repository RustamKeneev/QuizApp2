package com.example.quizapp2;

import android.app.Application;

import com.example.quizapp2.data.IQuizRepository;
import com.example.quizapp2.data.QuizRepository;

public class App extends Application {

    public  static IQuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository();
    }
}
