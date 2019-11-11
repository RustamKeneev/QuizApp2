package com.example.quizapp2.ui.quiz.quiz_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.R;
import com.example.quizapp2.model.Question;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Question> questionArrayList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_questions,parent,false);
        return new QuizViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        questionArrayList.get(position).getQuestion_text();
    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }
}
