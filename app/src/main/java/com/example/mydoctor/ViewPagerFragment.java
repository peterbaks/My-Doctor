package com.example.mydoctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationview.R;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

       // getActivity().getActionBar().hide();

        ViewPager2 viewPager2 = view.findViewById(R.id.myViewPager);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new start1());
        arrayList.add(new start2());
        arrayList.add(new start3());
        arrayList.add(new start4());
        arrayList.add(new start5());
        arrayList.add(new start6());

        ViewPagerAdapter adapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager(),getLifecycle(),arrayList);
        viewPager2.setAdapter(adapter);



        return view;
    }
}