package com.student.greentrail.ui.Maps;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.student.greentrail.R;
import com.student.greentrail.databinding.FragmentAddLocationBinding;
import com.student.greentrail.ui.home.HomeFragment;

public class AddLocationFragment extends Fragment {

    FragmentAddLocationBinding binding;
    Button btnSubmitLocation;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;

    public AddLocationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseDatabase = firebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddLocationBinding.inflate(inflater, container, false);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Uploading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        // When click submit button, add new location to database
        binding.btnSubmitLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                LocationModel newLocation = new LocationModel();
                newLocation.setName(binding.etAddName.getText().toString().trim());
                newLocation.setLatitude(Double.parseDouble(binding.etAddLatitude.getText().toString().trim()));
                newLocation.setLongitude(Double.parseDouble(binding.etAddLongitude.getText().toString().trim()));

                firebaseDatabase.getReference().child("newLocation").push().setValue(newLocation).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        progressDialog.dismiss();
                        // Make toast to show that location has been added to database
                        Toast.makeText(getContext(), "Location Added", Toast.LENGTH_SHORT).show();

                        // Go back to the home page once the location has been added
                        Fragment fragment = new HomeFragment();
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, fragment).commit();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"ERROR" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
            }
        });

        return binding.getRoot();
    }
}