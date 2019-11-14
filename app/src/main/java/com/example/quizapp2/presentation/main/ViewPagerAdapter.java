package com.example.quizapp2.presentation.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.quizapp2.presentation.ui.settings.SettingsFragment;
import com.example.quizapp2.presentation.ui.history.HistoryFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new SettingsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
