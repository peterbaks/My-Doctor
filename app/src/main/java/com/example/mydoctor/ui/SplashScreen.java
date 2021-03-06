package com.example.mydoctor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.mydoctor.onboarding.ViewPagerActivity;
import com.example.mydoctor.ui.activities.MainActivity;
import com.example.mydoctor.ui.activities.SignInActivity;
import com.example.navigationview.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                if (mFirebaseUser != null && onboardingDone()){
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                }
                else if (onboardingDone()){
                    Intent intent = new Intent(SplashScreen.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashScreen.this, ViewPagerActivity.class);
                    startActivity(intent);
                    finish();
                }

            }},3000);
    }

    private boolean onboardingDone(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("finished",false);
    }
}