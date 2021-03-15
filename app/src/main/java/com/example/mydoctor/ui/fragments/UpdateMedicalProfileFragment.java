package com.example.mydoctor.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mydoctor.model.Profile;
import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentUpdateMedicalProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import timber.log.Timber;

public class UpdateMedicalProfileFragment extends Fragment {

    FragmentUpdateMedicalProfileBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateMedicalProfileBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

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
                updateMedicalProfile();
            }
        });

        binding.mpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_updateMedicalProfileFragment_to_homeFragment);
            }
        });

        fetchMedicalProfile();

        return view;
    }

    private void fetchMedicalProfile(){
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Profile profile = snapshot.getValue(Profile.class);
                    assert profile != null;
                    Timber.d(profile.getFirstName());
                    Toast.makeText(requireContext(), ""+profile.getFirstName(), Toast.LENGTH_SHORT).show();
                    binding.progressBar4.setVisibility(View.INVISIBLE);
                    binding.fname.setText(profile.getFirstName());
                    binding.lname.setText(profile.getLastName());
                    binding.surname.setText(profile.getSurname());
                    binding.dob.setText(profile.getDob());
                    binding.age.setText(profile.getAge());
                    binding.nationality.setText(profile.getNationality());
                    binding.nationalId.setText(profile.getNation_id());
                    binding.telNo.setText(profile.getPhoneNum());
                    binding.language.setText(profile.getLanguages_fluent());
                    binding.county.setText(profile.getCounty());
                    binding.locality.setText(profile.getLocality());
                    binding.nextOfKin.setText(profile.getNext_of_kin());
                    binding.gfname.setText(profile.getGuardian_firstName());
                    binding.glname.setText(profile.getGuardian_lastName());
                    binding.gId.setText(profile.getGuardian_id());
                    binding.guardianPhoneNo.setText(profile.getGuardian_phoneNum());
                    binding.gLocality.setText(profile.getGuardian_locality());
                    binding.bloodGroup.setText(profile.getBloodGroup());
                    binding.bloodpressure.setText(profile.getBloodPressure());
                    binding.height.setText(profile.getHeight());
                    binding.weight.setText(profile.getWeight());
                    binding.existingCondition.setText(profile.getExistingMedCondition());

                    Timber.d(profile.getFirstName());
                }else{
                    Toast.makeText(requireContext(), "Data does not exist", Toast.LENGTH_SHORT).show();
                    binding.progressBar4.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void updateMedicalProfile(){
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("firstName").setValue(binding.fname.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("lastName").setValue(binding.lname.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("surname").setValue(binding.surname.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("dob").setValue(binding.dob.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("age").setValue(binding.age.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("gender").setValue("binding.fname.getText().toString()");
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("nationality").setValue(binding.nationality.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("nation_id").setValue(binding.nationalId.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("phoneNum").setValue(binding.telNo.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("languages_fluent").setValue(binding.language.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("county").setValue(binding.county.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("locality").setValue(binding.locality.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("next_of_kin").setValue(binding.nextOfKin.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("guardian_id").setValue(binding.gId.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("guardian_firstName").setValue(binding.gfname.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("guardian_lastName").setValue(binding.glname.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("guardian_phoneNum").setValue( binding.guardianPhoneNo.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("guardian_locality").setValue( binding.gLocality.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("bloodGroup").setValue(binding.bloodGroup.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("bloodPressure").setValue(binding.bloodpressure.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("height").setValue(binding.height.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("weight").setValue(binding.weight.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("existingMedCondition").setValue(binding.existingCondition.getText().toString());
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("hivStatus").setValue("binding.fname.getText().toString()");

        Toast.makeText(requireContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();

        Navigation.findNavController(requireView()).navigate(R.id.action_updateMedicalProfileFragment_to_successFragment);
    }
}