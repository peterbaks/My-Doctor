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
                if(binding.fname.getText().toString().isEmpty()){
                    binding.fname.setError("Required");
                }
                else if (binding.lname.getText().toString().isEmpty()){
                    binding.lname.setError("Required");
                }
                else if (binding.surname.getText().toString().isEmpty()){
                    binding.surname.setError("Required");
                }
                else if (binding.dob.getText().toString().isEmpty()){
                    binding. dob.setError("Required");
                }
                else if (binding.age.getText().toString().isEmpty()){
                    binding.age.setError("Required");
                }
                else if (binding.male.getText().toString().isEmpty()){
                    binding.male.setError("Required");
                }
                else if (binding.female.getText().toString().isEmpty()){
                    binding.female.setError("Required");
                }
                else if (binding.nationality.getText().toString().isEmpty()){
                    binding.nationality.setError("Required");
                }
                else if (binding.nationalId.getText().toString().isEmpty()){
                    binding.nationalId.setError("Required");
                }
                else if (binding.telNo.getText().toString().isEmpty()){
                    binding.telNo.setError("Required");
                }
                else if (binding.language.getText().toString().isEmpty()){
                    binding.language.setError("Required");
                }
                else if (binding.county.getText().toString().isEmpty()){
                    binding.county.setError("Required");
                }
                else if (binding.locality.getText().toString().isEmpty()){
                    binding.locality.setError("Required");
                }
                else if (binding.gfname.getText().toString().isEmpty()){
                    binding.gfname.setError("Required");
                }
                else if (binding.nextOfKin.getText().toString().isEmpty()){
                    binding.nextOfKin.setError("Required");
                }
                else if (binding.glname.getText().toString().isEmpty()){
                    binding.glname.setError("Required");
                }
                else if (binding.gId.getText().toString().isEmpty()){
                    binding.gId.setError("Required");
                }
                else if (binding.guardianPhoneNo.getText().toString().isEmpty()){
                    binding.guardianPhoneNo.setError("Required");
                }
                else if (binding.gLocality.getText().toString().isEmpty()){
                    binding.gLocality.setError("Required");
                }
                else if (binding.bloodGroup.getText().toString().isEmpty()){
                    binding.bloodGroup.setError("Required");
                }
                else if (binding.bloodpressure.getText().toString().isEmpty()){
                    binding.bloodpressure.setError("Required");
                }
                else if (binding.height.getText().toString().isEmpty()){
                    binding.height.setError("Required");
                }
                else if (binding.weight.getText().toString().isEmpty()){
                    binding.weight.setError("Required");
                }
                else if (binding.existingCondition.getText().toString().isEmpty()){
                    binding.existingCondition.setError("Required");
                }
                else if (binding.positiveHiv.getText().toString().isEmpty()){
                    binding.positiveHiv.setError("Required");
                }
                else if (binding.negativeHiv.getText().toString().isEmpty()){
                    binding.negativeHiv.setError("Required");
                }
                else
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
                binding.dob.getText().toString(),
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
                binding.gLocality.getText().toString(),
                binding.bloodGroup.getText().toString(),
                binding.bloodpressure.getText().toString(),
                binding.height.getText().toString(),
                binding.weight.getText().toString(),
                binding.existingCondition.getText().toString(),
                "binding.fname.getText().toString()");

        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(profile);
    }
}