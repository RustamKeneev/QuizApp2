package com.example.quizapp2.ui.history.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.R;

public class QuizHistoryViewModel extends RecyclerView.ViewHolder {
    TextView category_text;
    ImageView ic_more_horizontal;
    TextView correct_answers_text;
    TextView correct_answers_text_result;
    TextView difficulty_text;
    TextView difficulty_text_categories;
    TextView history_date;



    public QuizHistoryViewModel(@NonNull View itemView) {
        super(itemView);

        category_text = itemView.findViewById(R.id.category_text);
        ic_more_horizontal = itemView.findViewById(R.id.ic_more_horizontal);
        correct_answers_text = itemView.findViewById(R.id.correct_answers_text);
        correct_answers_text_result = itemView.findViewById(R.id.correct_answers_text_result);
        difficulty_text = itemView.findViewById(R.id.difficulty_text);
        difficulty_text_categories = itemView.findViewById(R.id.difficulty_text_categories);
        history_date = itemView.findViewById(R.id.history_date);
    }
}
