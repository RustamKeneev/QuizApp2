package com.example.quizapp2.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.quizapp2.R;
import com.example.quizapp2.data.IQuizRepository;
import com.example.quizapp2.data.QuizRepository;
import com.example.quizapp2.model.Question;
//import com.example.quizapp2.ui.settings.SettingsFragment;
//import com.example.quizapp2.ui.settings.SettingsViewModel;
import com.example.quizapp2.ui.history.HistoryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private HistoryViewModel historyViewModel;
    private SettingsViewModel settingsViewModel;

    private ViewPager mViewPager;
    private BottomNavigationView mNavigation;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModelProviders();
        viewModelObserve();
        settingViewPager();
    }

    private void initViewModelProviders() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
//        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
    }

    private void viewModelObserve() {
        historyViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("ololo", "Main activity " + s);
//                settingsViewModel.onHistoryCleared();
            }
        });
//        settingsViewModel.title.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.d("ololo", "Main activity " + s);
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new QuizRepository().getQuiz(new IQuizRepository.OnQuizCallback() {
            @Override
            public void onSuccess(List<Question> questions) {
                for (Question question : questions){

                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("ololo", "Failed: " + e.getMessage());
            }
        });
    }

    private void settingViewPager() {
        mViewPager = findViewById(R.id.main_view_pager);
        mNavigation = findViewById(R.id.bottom_navigation);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int selectedItem = R.id.nav_main;

                switch (position) {
                    case 1:
                        selectedItem = R.id.nav_history;
                        break;
                    case 2:
                        selectedItem = R.id.nav_settings;
                        break;
                }

                mNavigation.setSelectedItemId(selectedItem);
            }
        });
    }
}

