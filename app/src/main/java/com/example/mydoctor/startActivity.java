package com.example.mydoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.navigationview.R;

import java.util.ArrayList;

public class startActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        getSupportActionBar().hide();

        ViewPager2 viewPager2 = findViewById(R.id.myViewPager);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new start1());
        arrayList.add(new start2());
        arrayList.add(new start3());
        arrayList.add(new start4());
        arrayList.add(new start5());
        arrayList.add(new start6());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle(),arrayList);
        viewPager2.setAdapter(adapter);



    }
}