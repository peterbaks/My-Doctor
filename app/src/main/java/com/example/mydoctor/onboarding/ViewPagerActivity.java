package com.example.mydoctor.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.navigationview.R;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        getSupportActionBar().hide();

        ViewPager2 viewPager2 = findViewById(R.id.myViewPager);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new ScreenOne());
        arrayList.add(new ScreenTwo());
        arrayList.add(new ScreenThree());
        arrayList.add(new ScreenFour());
        arrayList.add(new ScreenFive());
        arrayList.add(new ScreenSix());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle(),arrayList);
        viewPager2.setAdapter(adapter);
    }
}