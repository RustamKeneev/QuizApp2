package com.example.quizapp2.presentation.ui.quiz_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp2.App;
import com.example.quizapp2.R;
import com.example.quizapp2.data.IQuizRepository;
import com.example.quizapp2.model.Question;
import com.example.quizapp2.presentation.main.MainActivity;
import com.example.quizapp2.presentation.ui.quiz_recycler.recycler.QuizAdapter;
import com.example.quizapp2.presentation.ui.quiz_recycler.recycler.QuizViewHolder;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

//    private QuizViewHolder quizViewHolder;
    private RecyclerView quiz_recyclerView;
    private QuizAdapter quizAdapter;
    private ProgressBar progressBar;
    private TextView progressText;
    private TextView title_text;
    private TextView title_skip;
    private ImageView quiz_back;
    private final static String EXTRA_AMMOUNT = "ammount";
    private final static String EXTRA_DIFFICULTY = "difficulty";

    public static void start(Context context,int ammount,String difficulty){
        Intent intent = new Intent(context,QuizActivity.class);
        intent.putExtra(EXTRA_AMMOUNT,ammount);
        intent.putExtra(EXTRA_DIFFICULTY,difficulty);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initView();
        initViewModelProviders();

        int amount = getIntent().getIntExtra(EXTRA_AMMOUNT,5);
        String difficulty = getIntent().getStringExtra(EXTRA_DIFFICULTY);

        App.quizRepository.getQuiz(new IQuizRepository.OnQuizCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                for (Question question : questions){
                    Log.d("ololo",question.toString());
                }
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
//                Log.d("ololo", "onFailure: " + e.getMessage());
            }
        });

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
//        quizViewHolder = ViewModelProviders.of(this).get(QuizViewHolder.class);
    }
}
