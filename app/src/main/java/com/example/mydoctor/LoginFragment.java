package com.example.mydoctor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.example.navigationview.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {
    FirebaseAuth firebaseAuth;
    MaterialButton signIn;
    MaterialButton singUp;
    EditText email;
    EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login2, container, false);
        setHasOptionsMenu(true);

        firebaseAuth = FirebaseAuth.getInstance();
        MaterialButton signIn = view.findViewById(R.id.buttonSignIn);
        MaterialButton signUp = view.findViewById(R.id.signup);
        EditText email = view.findViewById (R.id.emailEditText);
        EditText password = view.findViewById (R.id.passwordEditText);

        //signUp.setOnClickListener(v ->
        //Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment));

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String passwd = password.getText().toString().trim();

                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Field can't be empty!!");
                    return;
                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    password.setError("Field can't be empty!!");
                    return;
                } else {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(mail, passwd).addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        //Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_homeFragment2);
                        Toast.makeText(getContext(), "welcome", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Something Went Wrong.\n please check your details and try again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return  view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.discovery_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.signOut){
            Toast.makeText(requireContext(), "Sign out", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}