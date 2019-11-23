package com.hci.StarkIndustries.ui.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.IdentifiableFragment;
import com.hci.StarkIndustries.ui.Miniatures.RoomDevices.RoomDevicesListFragment;

public class RoomFragment extends IdentifiableFragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_room, container, false);

//        RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager().findFragmentById(R.id.RoomDevicesFragmentContainer);
//
//        fragment.setID(id);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        mViewModel.getModel(this, this.getID()).observe(this, roomModel -> {
            ((TextView) getView().findViewById(R.id.RoomTitle)).setText(roomModel.getName());

            RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager()
                    .findFragmentById(R.id.RoomDevicesFragmentContainer);

//            RecyclerView recyclerView = getView().findViewById(R.id.HouseRoomRecyclerView);

//            if (arrayListResult.ok()) {
//                ((RecyclerViewRegionsAdapter) recyclerView.getAdapter()).setData(arrayListResult.getResult());
//                if (arrayListResult.getResult().size() == 0) {
//                    getView().findViewById(R.id.NoRegionsView).setVisibility(View.VISIBLE);
//                } else {
//                    getView().findViewById(R.id.NoRegionsView).setVisibility(View.GONE);
//                }
//            } else {
//                // TODO: ERROR
//            }
        });
    }
}
