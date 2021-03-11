package com.example.mydoctor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.mydoctor.model.Diseases;
import com.example.mydoctor.model.DiseasesDao;
import com.example.mydoctor.model.DiseasesDatabase;
import com.example.mydoctor.onboarding.ViewPagerActivity;
import com.example.mydoctor.ui.activities.MainActivity;
import com.example.mydoctor.ui.activities.SignInActivity;
import com.example.navigationview.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    DiseasesDao diseasesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        DiseasesDatabase database = DiseasesDatabase.getInstance(getApplicationContext());
        diseasesDao = database.diseasesDao();

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
                    Diseases diseases = new Diseases("Malaria","Vomiting, Fever","Buy mosquito net");
                    Diseases diseases2 = new Diseases("Tuberclosis","Bleeding, Sweating","Visit nearby hospital");
                    Diseases diseases3 = new Diseases("Typhoid","Vomiting, Red Eyes","Take warm water");
                    Diseases diseases4 = new Diseases("HIV/AIDs","Shivering","Wear heavy clothes");
                    insertDisease(diseases);
                    insertDisease(diseases2);
                    insertDisease(diseases3);
                    insertDisease(diseases4);


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

    public void insertDisease(Diseases diseases){
        new InsertDiseaseAsynTask(diseasesDao).execute(diseases);
        Toast.makeText(getApplication(), "Added diseases", Toast.LENGTH_SHORT).show();
    }

    private static class InsertDiseaseAsynTask extends AsyncTask<Diseases,Void,Void> {

        private DiseasesDao diseasesDao;

        private InsertDiseaseAsynTask(DiseasesDao diseasesDao){
            this.diseasesDao = diseasesDao;
        }

        @Override
        protected Void doInBackground(Diseases... diseases) {
            diseasesDao.insert(diseases[0]);
            return null;
        }
    }
}