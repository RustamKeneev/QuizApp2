package com.example.quizapp2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.example.quizapp2.settings.SettingsViewModel;
import com.example.quizapp2.ui.history.HistoryFragment;
import com.example.quizapp2.ui.history.HistoryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private HistoryViewModel historyViewModel;
    private SettingsViewModel settingsViewModel;

    private ViewPager mViewPager;
    private MainPagerAdapter mainPagerAdapter;
    private BottomNavigationView mNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.main_view_pager);
        mNavigation = findViewById(R.id.bottom_navigation);

        mViewPager.setAdapter(mainPagerAdapter);



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


private class MainPagerAdapter extends FragmentPagerAdapter{

    public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = MainFragment.newInstance();
                break;
                default: fragment = HistoryFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

}
