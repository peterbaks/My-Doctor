package com.example.mydoctor.ui.fragments;

import android.content.Intent;
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
import com.example.mydoctor.others.SignOut;
import com.example.mydoctor.ui.activities.SignInActivity;
import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentPersonalProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonalProfileFragment extends Fragment {

    FragmentPersonalProfileBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPersonalProfileBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        setHasOptionsMenu(true);

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.quit.setVisibility(View.INVISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference("medical_profile");
        firebaseAuth = FirebaseAuth.getInstance();

        fetchPersonalProfile();

        binding.quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_personalProfileFragment_to_homeFragment);
            }
        });

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
            SignOut.signOut();
            Intent intent = new Intent(getActivity(), SignInActivity.class);
            startActivity(intent);
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchPersonalProfile(){

        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Profile profile = snapshot.getValue(Profile.class);
                    binding.fname.setText("First Name: "+profile.getFirstName());
                    binding.lname.setText("Last Name: "+profile.getLastName());
                    binding.surname.setText("Surname: "+profile.getSurname());
                    binding.dOB.setText("Date of Birth: "+profile.getDob());
                    binding.age.setText("Age: "+profile.getAge());
                    binding.nationality.setText("Nationality: "+profile.getNationality());
                    binding.nationalId.setText("National ID: "+profile.getNation_id());
                    binding.telNo.setText("Phone No: "+profile.getPhoneNum());
                    binding.language.setText("Languages fluent: "+profile.getLanguages_fluent());
                    binding.county.setText("County of Origin: "+profile.getCounty());
                    binding.locality.setText("Locality: "+profile.getLocality());

                    binding.progressBar.setVisibility(View.INVISIBLE);
                    binding.quit.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(requireContext(), "Data does not exist", Toast.LENGTH_SHORT).show();
                    binding.progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });
    }
}