package com.example.mydoctor.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mydoctor.model.Profile;
import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentMedicalProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MedicalProfileFragment extends Fragment {

    FragmentMedicalProfileBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMedicalProfileBinding.inflate(inflater,container,false);
        View view= binding.getRoot();

        databaseReference = FirebaseDatabase.getInstance().getReference("medical_profile");
        firebaseAuth = FirebaseAuth.getInstance();

        binding.saveMedicalProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMedicalProfile();
                Navigation.findNavController(v).navigate(R.id.action_medicalProfileFragment_to_successFragment);
            }
        });

        setHasOptionsMenu(true);
        return view;
    }
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

    private void createMedicalProfile(){
        Profile profile = new Profile(
                binding.fname.getText().toString(),
                binding.lname.getText().toString(),
                binding.surname.getText().toString(),
                binding.dOB.getText().toString(),
                binding.age.getText().toString(),
                "binding.fname.getText().toString()",
                binding.nationality.getText().toString(),
                binding.nationalId.getText().toString(),
                binding.telNo.getText().toString(),
                binding.language.getText().toString(),
                binding.county.getText().toString(),
                binding.locality.getText().toString(),
                binding.gfname.getText().toString(),
                binding.gId.getText().toString(),
                binding.glname.getText().toString(),
                binding.gId.getText().toString(),
                binding.guardianPhoneNo.getText().toString(),
                binding.GLocality.getText().toString(),
                binding.bloodGroup.getText().toString(),
                binding.bloodpressure.getText().toString(),
                binding.height.getText().toString(),
                binding.weight.getText().toString(),
                binding.existingCondition.getText().toString(),
                "binding.fname.getText().toString()");

        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(profile);
    }
}