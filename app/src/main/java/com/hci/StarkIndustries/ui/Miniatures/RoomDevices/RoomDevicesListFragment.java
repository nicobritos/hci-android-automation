package com.hci.StarkIndustries.ui.Miniatures.RoomDevices;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;

public class RoomDevicesListFragment extends DevicesListFragment {

    public RoomDevicesListFragment newInstance(String roomID){
        RoomDevicesListFragment f = new RoomDevicesListFragment();

        Bundle args = new Bundle();
        args.putString("roomId",roomID);
        f.setArguments(args);

        return f;

    }


    public void LoadViewModel(){
        mViewModel = ViewModelProviders.of(this).get(RoomDevicesListViewModel.class);

        ((RoomDevicesListViewModel)mViewModel).SetID(this.getArguments().getString("roomId"));

    }


}
