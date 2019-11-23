package com.hci.StarkIndustries.ui.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.Miniatures.RoomDevices.RoomDevicesListFragment;

public class RoomFragment extends Fragment {
    private RoomViewModel mViewModel;
    private String id = "";

    public RoomFragment() {
        // Required empty public constructor
    }


    public static RoomFragment newInstance() {
        RoomFragment fragment = new RoomFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_room, container, false);

        RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager().findFragmentById(R.id.RoomDevicesFragmentContainer);

//        fragment.setID(id);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        mViewModel.getModel(id).observe(this, roomModel -> {
            ((TextView) getView().findViewById(R.id.RoomTitle)).setText(roomModel.getName());

            RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager()
                    .findFragmentById(R.id.RoomDevicesFragmentContainer);
        });


    }
}
