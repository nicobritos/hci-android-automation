package com.hci.StarkIndustries.ui.Miniatures.RoomDevices;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;

public class RoomDevicesListFragment extends DevicesListFragment {
    private String roomId;

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    protected int getOrientation() {
        return RecyclerView.VERTICAL;
    }

    public RoomDevicesListFragment newInstance(String roomID) {
        RoomDevicesListFragment f = new RoomDevicesListFragment();

        Bundle args = new Bundle();
        args.putString("roomId", roomID);
        f.setArguments(args);

        return f;
    }

    public void LoadViewModel() {
        mViewModel = ViewModelProviders.of(this).get(RoomDevicesListViewModel.class);
        ((RoomDevicesListViewModel) mViewModel).setId(roomId);
    }
}
