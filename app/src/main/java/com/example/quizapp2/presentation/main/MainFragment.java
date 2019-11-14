package com.example.quizapp2.presentation.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp2.R;
import com.example.quizapp2.presentation.ui.quiz.QuizActivity;

public class MainFragment extends Fragment {

    private AppCompatSeekBar appCompatSeekBar;
    private AppCompatSpinner categorySpiner;
    private AppCompatSpinner difficultySpiner;
    private TextView main_questions_amount;
    private View viewStart;


//    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appCompatSeekBar = view.findViewById(R.id.main_amount_seek_bar);
        categorySpiner = view.findViewById(R.id.main_category_spinner);
        difficultySpiner = view.findViewById(R.id.main_difficult_spinner);
        main_questions_amount = view.findViewById(R.id.main_questions_amount);
        viewStart = view.findViewById(R.id.main_start);

        appCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                main_questions_amount.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        viewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizActivity.start(getContext(),appCompatSeekBar.getProgress());
                categorySpiner.getSelectedItemPosition();
                difficultySpiner.getSelectedItemPosition();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
