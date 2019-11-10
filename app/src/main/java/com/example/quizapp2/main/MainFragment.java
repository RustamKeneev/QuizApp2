package com.example.quizapp2.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp2.R;

public class MainFragment extends Fragment {

    private AppCompatSeekBar appCompatSeekBar;
    private AppCompatSpinner categorySpiner;
    private AppCompatSpinner difficultySpiner;
    private TextView main_questions_amount;
    private View viewStart;


    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appCompatSeekBar = view.findViewById(R.id.main_amount_seek_bar);
        categorySpiner = view.findViewById(R.id.main_category_spinner);
        difficultySpiner = view.findViewById(R.id.main_difficult_spinner);
        main_questions_amount = view.findViewById(R.id.main_questions_amount);
        viewStart = view.findViewById(R.id.main_start);

        viewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"click",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }

}
