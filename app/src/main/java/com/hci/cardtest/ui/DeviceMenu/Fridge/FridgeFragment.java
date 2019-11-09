package com.hci.cardtest.ui.DeviceMenu.Fridge;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FridgeFragment extends Fragment {

    private FridgeViewModel mViewModel;

    public static FridgeFragment newInstance() {
        return new FridgeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(com.hci.cardtest.R.layout.fridge_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FridgeViewModel.class);
        // TODO: Use the ViewModel
    }

}
