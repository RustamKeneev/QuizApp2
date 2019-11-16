package com.example.quizapp2.presentation.main;

import androidx.appcompat.widget.AppCompatSeekBar;

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

import com.example.quizapp2.R;
import com.example.quizapp2.presentation.ui.quiz_recycler.QuizActivity;

import org.angmarch.views.NiceSpinner;

public class MainFragment extends Fragment {

    private AppCompatSeekBar appCompatSeekBar;
    private NiceSpinner categorySpiner;
    private NiceSpinner difficultySpiner;
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
        appCompatSeekBar.setProgress(5);
        categorySpiner = view.findViewById(R.id.main_category_spinner);
        difficultySpiner = view.findViewById(R.id.main_difficult_spinner);
        main_questions_amount = view.findViewById(R.id.main_questions_amount);
        viewStart = view.findViewById(R.id.main_start);

        appCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i < 6 ){
                    appCompatSeekBar.setProgress(5);
                }
                main_questions_amount.setText(String.valueOf(appCompatSeekBar.getProgress()));
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
                QuizActivity.start(getContext(),appCompatSeekBar.getProgress(),"easy");
                categorySpiner.getSelectedItem().toString();
//                difficultySpiner.getOnSpinnerItemSelectedListener();

                Log.d("ololo", "Start properties - amount:" + appCompatSeekBar.getProgress()
                        + " category: " + categorySpiner.getSelectedIndex()
                        + " difficulty: " + difficultySpiner.getSelectedIndex());
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
