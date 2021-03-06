package com.example.mydoctor.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigationview.R;


public class ScreenFour extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screenfour, container, false);

        Button start4 = view.findViewById(R.id.start4);
        ViewPager2 viewPager2 = getActivity().findViewById(R.id.myViewPager);

        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(4);
            }
        });
        return view;
    }
}