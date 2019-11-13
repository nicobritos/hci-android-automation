package com.hci.StarkIndustries.ui.Miniatures.FavouriteDevices;

import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;

public class FavoriteDevicesListFragment extends DevicesListFragment {


    public void LoadViewModel(){
        mViewModel = ViewModelProviders.of(this).get(FavoriteDevicesListViewModel.class);
    }


}
