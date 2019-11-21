package com.hci.StarkIndustries.ui.Miniatures.RoomDevices;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;

public class RoomDevicesListFragment extends DevicesListFragment {

    @Override
    protected int getOrientation(){
        return RecyclerView.VERTICAL;
    }

    private String id = "";


    public RoomDevicesListFragment newInstance(String roomID){
        RoomDevicesListFragment f = new RoomDevicesListFragment();

        Bundle args = new Bundle();
        args.putString("roomId",roomID);
        f.setArguments(args);

        return f;

    }

    @Override
    public void LoadViewModel(){
        mViewModel = ViewModelProviders.of(this).get(RoomDevicesListViewModel.class);
        //((RoomDevicesListViewModel)mViewModel).SetID(this.getArguments().getString("roomId"));

        ((RoomDevicesListViewModel)mViewModel).SetID(this.id);
    }

    public int getDevicesInRoom(){
        return mViewModel.getModel().getValue().getDevices().size();
    }

    public void setID(String id){
        this.id = id;
    }


}
