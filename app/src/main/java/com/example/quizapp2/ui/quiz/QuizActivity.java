package com.example.quizapp2.ui.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp2.R;
import com.example.quizapp2.main.MainActivity;
import com.example.quizapp2.ui.quiz.quiz_recycler.QuizAdapter;

public class QuizActivity extends AppCompatActivity {

    private QuizViewModel quizViewModel;
    private RecyclerView quiz_recyclerView;
    private QuizAdapter quizAdapter;
    private ProgressBar progressBar;
    private TextView progressText;
    private TextView title_text;
    private TextView title_skip;
    private ImageView quiz_back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initView();
        initViewModelProviders();

    }

    private void initView() {
        progressBar = findViewById(R.id.quiz_progress);
        progressText = findViewById(R.id.quiz_progress_text);
        title_text = findViewById(R.id.quiz_title);
        quiz_back = findViewById(R.id.quiz_back);
        quiz_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainFrafmentIntent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(mainFrafmentIntent);
            }
        });

        title_skip = findViewById(R.id.quiz_skip);
        title_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this,"clicked skip",Toast.LENGTH_SHORT).show();
            }
        });
        initRecycler();
    }

    private void initRecycler() {
        quizAdapter = new QuizAdapter();
        quiz_recyclerView = findViewById(R.id.quiz_recycler);
        quiz_recyclerView.setAdapter(quizAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this,
                RecyclerView.HORIZONTAL,
                false);
        quiz_recyclerView.setLayoutManager(layoutManager);
    }

    private void initViewModelProviders() {
        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
    }
}
