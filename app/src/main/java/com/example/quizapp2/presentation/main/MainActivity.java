package com.example.quizapp2.presentation.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.quizapp2.presentation.ui.settings.SettingsViewModel;
import com.example.quizapp2.R;
import com.example.quizapp2.data.IQuizRepository;
import com.example.quizapp2.data.QuizRepository;
import com.example.quizapp2.model.Question;
//import com.example.quizapp2.presentation.ui.settings.SettingsFragment;
//import com.example.quizapp2.presentation.ui.settings.SettingsViewModel;
import com.example.quizapp2.presentation.ui.history.HistoryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        settingBottomnavigationView();
    }

    private void settingBottomnavigationView() {
        mNavigation = findViewById(R.id.bottom_navigation);
        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_main:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_history:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_settings:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }

    private void initViewModelProviders() {
//        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
//        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
    }

    private void viewModelObserve() {
//        historyViewModel.title.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.d("ololo", "Main activity " + s);
////                settingsViewModel.onHistoryCleared();
//            }
//        });
//        settingsViewModel.title.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.d("ololo", "Main activity " + s);
//            }
//        });
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        new QuizRepository().getQuiz(new IQuizRepository.OnQuizCallback() {
//            @Override
//            public void onSuccess(List<Question> questions) {
//                for (Question question : questions){
//
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Log.d("ololo", "Failed: " + e.getMessage());
//            }
//        });
//    }

    private void settingViewPager() {
        mViewPager = findViewById(R.id.main_view_pager);
        mNavigation = findViewById(R.id.bottom_navigation);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mNavigation.setSelectedItemId(R.id.nav_main);
                        break;
                    case 1:
                        mNavigation.setSelectedItemId(R.id.nav_history);
                        break;
                    case 2:
                        mNavigation.setSelectedItemId(R.id.nav_settings);
                        break;
                }
            }
        });
    }
}

