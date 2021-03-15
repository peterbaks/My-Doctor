package com.example.mydoctor.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mydoctor.others.SignOut;
import com.example.mydoctor.ui.activities.SignInActivity;
import com.example.navigationview.R;
import com.example.navigationview.databinding.FragmentContactsBinding;

public class contacts extends Fragment {
    FragmentContactsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentContactsBinding.inflate(inflater,container,false);
      View view = binding.getRoot();
        setHasOptionsMenu(true);
         binding.call.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String emagency_No ="+254796808883";
                 Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",emagency_No,null));
                 startActivity(intent);
             }
         });

         binding.email.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Intent.ACTION_SEND);
                 intent.setType("text/email");
                 intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pkibaki081@gmail.com"});
                 intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                 intent.putExtra(Intent.EXTRA_TEXT,"Type Your Message Here");
                 startActivity(Intent.createChooser(intent, "Contact Us"));
             }
         });
         binding.instagram.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String url ="https://www.instagram.com/peterbaks081/";

                 Intent intent = new Intent(Intent.ACTION_VIEW);
                 intent.setData(Uri.parse(url));
                 startActivity(intent);
             }
         });
          binding.telegram.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String url ="https://t.me/MyDoctor081Updates";

                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setData(Uri.parse(url));
                  startActivity(intent);
              }
          });
        binding.whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://chat.whatsapp.com/LPtf9ilwqF9HnmplbNdfQ6";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        binding.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://www.facebook.com/MyDoctor-106515698184653";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        return view;
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
            SignOut.signOut();
            Intent intent = new Intent(getActivity(), SignInActivity.class);
            startActivity(intent);
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}