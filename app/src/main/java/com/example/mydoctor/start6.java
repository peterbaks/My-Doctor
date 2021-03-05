package com.example.mydoctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigationview.R;


public class start6 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start6, container, false);

        Button start6 = view.findViewById(R.id.start6);
        start6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),signInActivity.class);
                startActivity(intent);
                isOnboardingFinished(requireContext());
                getActivity().finish();
            }
        });

        return view;
    }

    private void isOnboardingFinished(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("onBoarding",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("finished",true);
        editor.apply();
    }
}