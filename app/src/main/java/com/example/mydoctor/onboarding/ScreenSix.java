package com.example.mydoctor.onboarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mydoctor.ui.activities.MainActivity;
import com.example.mydoctor.ui.activities.SignInActivity;
import com.example.navigationview.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ScreenSix extends Fragment {

    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screensix, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        Button start6 = view.findViewById(R.id.start6);
        start6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                if (mFirebaseUser != null){
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    isOnboardingFinished(requireContext());
                    getActivity().finish();
                }else{
                    Intent intent = new Intent(getActivity(), SignInActivity.class);
                    startActivity(intent);
                    isOnboardingFinished(requireContext());
                    getActivity().finish();
                }
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