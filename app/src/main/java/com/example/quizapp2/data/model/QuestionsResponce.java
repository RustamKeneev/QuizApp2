package com.example.quizapp2.data.model;

import com.example.quizapp2.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsResponce {
    @SerializedName("response_code")
    private int responceCode;
    private List<Question> results;


    public QuestionsResponce(int responceCode, List<Question> questionsResults) {
        responceCode = responceCode;
        this.results = questionsResults;
    }

    public int getResponceCode() {
        return responceCode;
    }

    public void setResponceCode(int responceCode) {
        responceCode = responceCode;
    }

    public List<Question> getQuestionsResults() {
        return results;
    }

    public void setQuestionsResults(List<Question> questionsResults) {
        this.results = questionsResults;
    }
}
