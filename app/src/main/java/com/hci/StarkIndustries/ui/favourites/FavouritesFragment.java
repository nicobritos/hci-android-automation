package com.hci.StarkIndustries.ui.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceMenuContainerFragment;

public class FavouritesFragment extends Fragment {

    private FavouritesViewModel favouritesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        favouritesViewModel =ViewModelProviders.of(this).get(FavouritesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_favourites, container, false);


        return root;
    }
}