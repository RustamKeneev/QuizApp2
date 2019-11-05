package com.example.quizapp2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.example.quizapp2.ui.history.HistoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ViewPager mViewPager;
    private MainPagerAdapter mainPagerAdapter;
    private BottomNavigationView mNavigation;


    TextView main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.main_view_pager);
        mNavigation = findViewById(R.id.bottom_navigation);

        mViewPager.setAdapter(mainPagerAdapter);


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init();




        mainViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
//                main_text.setText(s);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainViewModel.changeTitle();
            }
        },2000);
//        Log.d("ololo", "Textview context is: " + main_text.getContext().toString());
    }

public class MainPagerAdapter extends FragmentPagerAdapter{

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
