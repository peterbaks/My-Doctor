package com.example.mydoctor.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mydoctor.model.DiseasesDao;
import com.example.mydoctor.model.DiseasesDatabase;
import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentPatientInputBinding;

import java.util.List;

public class PatientInputFragment extends Fragment {

    List<String> allDiseases;
    List<String> prescription;
    FragmentPatientInputBinding binding;
    DiseasesDao diseasesDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPatientInputBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setHasOptionsMenu(true);

        DiseasesDatabase database = DiseasesDatabase.getInstance(getActivity().getApplicationContext());
        diseasesDao = database.diseasesDao();

        binding.diagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.textViewPrescption.setVisibility(View.GONE);
                binding.textViewPossible.setVisibility(View.GONE);
                binding.textViewPrescriptionValue.setVisibility(View.GONE);
                binding.textViewPssibleDiseasesValue.setVisibility(View.GONE);
                binding.textViewVisitNearbyHospital.setVisibility(View.GONE);

                String argument = binding.symptoms.getText().toString();
                if (binding.symptoms.getText().toString().isEmpty()) {
                    binding.symptoms.setError("Symptoms are required");
                    return;
                } else if (binding.symptomsPeriod.getText().toString().isEmpty()) {
                    binding.symptomsPeriod.setError("Symptoms period are required");
                    return;
                } else if (binding.existingCondition.getText().toString().isEmpty()) {
                    binding.existingCondition.setError("Symptoms period are required");
                    return;
                }
                allDiseases = diseasesDao.diseaseDiagnosis(argument);
                prescription = diseasesDao.prescription(argument);
                showResult(allDiseases, prescription);
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_patientInputFragment_to_homeFragment);
            }
        });

        return view;
    }

    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.discovery_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.signOut) {
            Toast.makeText(requireContext(), "Sign out", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showResult(List<String> diseases, List<String> prescription) {

        if (diseases.isEmpty()) {
            binding.textViewVisitNearbyHospital.setVisibility(View.VISIBLE);
            binding.textViewPrescption.setVisibility(View.GONE);
            binding.textViewPossible.setVisibility(View.GONE);
            binding.textViewPrescriptionValue.setVisibility(View.GONE);
            binding.textViewPssibleDiseasesValue.setVisibility(View.GONE);
        } else {
            binding.textViewPssibleDiseasesValue.setText(allDiseases.toString());
            binding.textViewPrescriptionValue.setText(prescription.toString());
            binding.textViewPrescption.setVisibility(View.VISIBLE);
            binding.textViewPossible.setVisibility(View.VISIBLE);
            binding.textViewPrescriptionValue.setVisibility(View.VISIBLE);
            binding.textViewPssibleDiseasesValue.setVisibility(View.VISIBLE);
        }
    }
}