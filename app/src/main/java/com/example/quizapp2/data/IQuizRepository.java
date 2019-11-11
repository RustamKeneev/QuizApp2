package com.example.quizapp2.data;

import com.example.quizapp2.model.Question;

import java.util.List;

public interface IQuizRepository {

    void getQuiz(OnQuizCallback callback);

    interface OnQuizCallback {
        void onSuccess(List<Question> questions);

        void onFailure(Exception e);
    }
}
