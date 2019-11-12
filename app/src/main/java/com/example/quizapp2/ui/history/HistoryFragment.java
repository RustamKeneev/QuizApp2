package com.example.quizapp2.ui.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.example.quizapp2.core.CoreFragment;
import com.example.quizapp2.ui.history.recycler.QuizHistoryAdapter;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView historyRecycler;
    private QuizHistoryAdapter quizHistoryAdapter;


    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.history_fragment;
//    }
//

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(HistoryViewModel.class);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyRecycler = view.findViewById(R.id.recycler_history);
        quizHistoryAdapter = new QuizHistoryAdapter();
        historyRecycler.setAdapter(quizHistoryAdapter);
        historyRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));




    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);

    }

}
