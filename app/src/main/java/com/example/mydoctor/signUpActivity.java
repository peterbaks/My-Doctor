package com.example.mydoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.navigationview.R;
import com.example.navigationview.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUpActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String userID;

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        //binding.signupTextView.setOnClickListener(v ->
                //Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_loginFragment));

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = binding.enterEmail.getText().toString().trim();
                String pass = binding.enterPassword.getText().toString().trim();
                String first_Name = binding.firstName.getText().toString().trim();
                String last_Name = binding.lastName.getText().toString().trim();
                String phone_Number = binding.phoneNumber.getText().toString().trim();
                Boolean agree_with_rules = binding.materialCheckBox.callOnClick();

                if (TextUtils.isEmpty(binding.enterEmail.getText().toString())) {
                    binding.enterEmail.setError("Field can't be empty!");
                    return;
                } else if (TextUtils.isEmpty(binding.enterPassword.getText().toString())) {
                    binding.enterPassword.setError("Field can't be empty!");
                    return;
                } else if (TextUtils.isEmpty(binding.firstName.getText().toString())) {
                    binding.firstName.setError("Field can't be empty!");
                    return;
                } else if (TextUtils.isEmpty(binding.lastName.getText().toString())) {
                    binding.lastName.setError("Field can't be empty!");
                    return;
                } else if (TextUtils.isEmpty(binding.phoneNumber.getText().toString())) {
                    binding.phoneNumber.setError("Field can't be empty!");
                    return;
                } else if (binding.phoneNumber.length() < 10) {
                    binding.phoneNumber.setError("Put correct Fields");
                    return;
                } else if (binding.enterPassword.length() < 6) {
                    binding.enterPassword.setError("Password should be 6 characters or more!");
                } else if (!isvalidemail(binding.enterEmail.getText().toString())) {
                    binding.enterEmail.setError("Invalid Email!");
                } else if (!binding.materialCheckBox.isChecked()) {
                    binding.materialCheckBox.setError("please check here!");
                    return;
                } else {
                    binding.registerProgressBar.setVisibility(View.VISIBLE);
                }

                firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            userID = firebaseAuth.getUid();
                            saveUserDetails(mail, first_Name, last_Name, phone_Number);
                            //Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_loginFragment);
                            Toast.makeText(signUpActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            binding.registerProgressBar.setVisibility(View.INVISIBLE);
                        } else {
                            Toast.makeText(signUpActivity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                            binding.registerProgressBar.setVisibility(View.INVISIBLE);
                        }

                    }
                });

            }
        });

        binding.signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUpActivity.this,signInActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private boolean isvalidemail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void saveUserDetails(String mail, String firstName, String lastName, String phoneNumber) {
       User user = new User(mail, firstName, lastName, phoneNumber);

       databaseReference.child(userID).setValue(user);
    }
}
