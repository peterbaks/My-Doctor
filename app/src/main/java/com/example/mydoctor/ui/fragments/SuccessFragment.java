package com.example.mydoctor.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentSuccessBinding;

public class SuccessFragment extends Fragment {

    FragmentSuccessBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSuccessBinding.inflate(inflater,container,false);

        View view = binding.getRoot();

        binding.buttonSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_successFragment_to_patientInputFragment);
            }
        });

        return view;
    }
}