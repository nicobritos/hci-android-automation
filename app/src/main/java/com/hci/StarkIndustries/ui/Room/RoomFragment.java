package com.hci.StarkIndustries.ui.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.APIReloadingFragment;
import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListFragment;
import com.hci.StarkIndustries.ui.Miniatures.RoomDevices.RoomDevicesListFragment;

public class RoomFragment extends APIReloadingFragment {
    private RoomViewModel mViewModel;

    public static RoomFragment newInstance() {
        return new RoomFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.setID(getArguments().getString("id"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_room, container, false);
        RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager().findFragmentById(R.id.RoomDevicesFragmentContainer);
        fragment.setRoomId(this.getID());

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        mViewModel.getModel(this, this.getID()).observe(this, roomModel -> {
            ((TextView) getView().findViewById(R.id.RoomTitle)).setText(roomModel.getName());
        });
    }

    @Override
    protected void reloadPage() {
        DevicesListFragment fragment = (DevicesListFragment) getChildFragmentManager().findFragmentById(R.id.RoomDevicesFragmentContainer);
        fragment.ReloadElements();
    }
}
