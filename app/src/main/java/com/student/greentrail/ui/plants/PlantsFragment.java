package com.student.greentrail.ui.plants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.student.greentrail.databinding.FragmentPlantBinding;

public class  PlantsFragment extends Fragment {

    private FragmentPlantBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlantsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(PlantsViewModel.class);

        binding = FragmentPlantBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPlant;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}