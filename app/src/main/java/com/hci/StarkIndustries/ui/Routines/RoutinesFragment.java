package com.hci.StarkIndustries.ui.Routines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;

public class RoutinesFragment extends Fragment {

    private static final String TAG = "RoutinesFragment";

    private RoutinesViewModel routinesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        routinesViewModel =
                ViewModelProviders.of(this).get(RoutinesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_routines, container, false);

        return root;
    }
}