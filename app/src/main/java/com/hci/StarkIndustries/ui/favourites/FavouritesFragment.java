package com.hci.StarkIndustries.ui.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hci.StarkIndustries.MainActivity;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.APIReloadingFragment;
import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;
import com.hci.StarkIndustries.ui.Miniatures.Routines.RoutinesListFragment;

public class FavouritesFragment extends APIReloadingFragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);
        ((MainActivity)getActivity()).SetTitleColor();
        return root;
    }

    @Override
    protected void reloadPage() {
        DevicesListFragment devices = (DevicesListFragment)getChildFragmentManager().findFragmentById(R.id.FAvDevicesFragment);
        devices.ReloadElements();

        RoutinesListFragment routines = (RoutinesListFragment)getChildFragmentManager().findFragmentById(R.id.FavRoutinesFragment);
        routines.ReloadElements();
    }
}