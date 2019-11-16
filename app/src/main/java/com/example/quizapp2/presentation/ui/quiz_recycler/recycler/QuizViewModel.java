package com.example.quizapp2.presentation.ui.quiz_recycler.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.R;

public class QuizViewModel extends RecyclerView.ViewHolder {

    TextView question_text;

    public QuizViewModel(@NonNull View itemView) {
        super(itemView);
        question_text = itemView.findViewById(R.id.question_text);
    }
}
