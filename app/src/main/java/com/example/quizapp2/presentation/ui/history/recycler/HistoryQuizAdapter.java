package com.example.quizapp2.presentation.ui.history.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.R;
import com.example.quizapp2.presentation.ui.history.HistoryModel;


import java.util.ArrayList;

public class HistoryQuizAdapter extends RecyclerView.Adapter<HistoryQuizAdapter.HistoryViewholder>{

    private Context context;
    private ArrayList<HistoryModel> historyModelArrayList;

    public HistoryQuizAdapter(Context context, ArrayList<HistoryModel> historyModelArrayList) {
        this.context = context;
        this.historyModelArrayList = historyModelArrayList;
    }

    @NonNull
    @Override
    public HistoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history,parent,false);
        return new HistoryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewholder holder, int position) {
        holder.category_text.setText(historyModelArrayList.get(position).getCategory());
//        holder.correct_answers_text_result.setText(historyModelArrayList.get(position).getCorrectAnswers());
        holder.difficulty_text.setText(historyModelArrayList.get(position).getDifficulty());
        holder.history_date.setText(historyModelArrayList.get(position).getTime()+"");
    }

    @Override
    public int getItemCount() {
        return historyModelArrayList.size();
    }

    public class HistoryViewholder extends RecyclerView.ViewHolder{
        TextView category_text;
        ImageView ic_more_horizontal;
        TextView correct_answers_text;
        TextView correct_answers_text_result;
        TextView difficulty_text;
        TextView difficulty_text_categories;
        TextView history_date;

        public HistoryViewholder(@NonNull View itemView) {
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
}
