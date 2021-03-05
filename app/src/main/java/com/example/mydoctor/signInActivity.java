package com.example.mydoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationview.R;
import com.example.navigationview.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        //signUp.setOnClickListener(v ->
        //Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment));

        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = binding.emailEditText.getText().toString().trim();
                String passwd = binding.passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(binding.emailEditText.getText().toString())) {
                    binding.emailEditText.setError("Field can't be empty!!");
                    return;
                } else if (TextUtils.isEmpty(binding.passwordEditText.getText().toString())) {
                    binding.passwordEditText.setError("Field can't be empty!!");
                    return;
                } else {
                    binding.registerProgressBar.setVisibility(View.VISIBLE);
                }

                firebaseAuth.signInWithEmailAndPassword(mail, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(signInActivity.this,MainActivity.class);
                            startActivity(intent);
                           finish();
                            Toast.makeText(signInActivity.this, "welcome", Toast.LENGTH_LONG).show();
                        }else{
                            binding.registerProgressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(signInActivity.this, ""+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signInActivity.this,signUpActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}