package com.example.mydoctor.others;

import com.google.firebase.auth.FirebaseAuth;

public class SignOut {

    public static void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

}
