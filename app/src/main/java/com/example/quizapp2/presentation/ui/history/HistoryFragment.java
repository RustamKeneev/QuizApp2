package com.example.quizapp2.presentation.ui.history;

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

import com.example.quizapp2.R;
import com.example.quizapp2.presentation.ui.history.recycler.HistoryQuizAdapter;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView historyRecycler;
    private HistoryQuizAdapter historyQuizAdapter;


    private ArrayList<HistoryModel> historyModelArrayList;



    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_history;
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

        historyModelArrayList = new ArrayList<>();

        historyRecycler = view.findViewById(R.id.recycler_history);
        historyQuizAdapter = new HistoryQuizAdapter(getContext(),historyModelArrayList);
        historyRecycler.setAdapter(historyQuizAdapter);
        historyRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));
        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));
        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));
        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));
        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));
        historyModelArrayList.add(new HistoryModel("String category","diffculty",10,10,"2019"));

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);

    }

}
