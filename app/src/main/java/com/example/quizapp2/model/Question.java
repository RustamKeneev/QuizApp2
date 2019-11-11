package com.example.quizapp2.model;

public class Question {
    private String question_text;

    public Question(String question_text) {
        this.question_text = question_text;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
}
