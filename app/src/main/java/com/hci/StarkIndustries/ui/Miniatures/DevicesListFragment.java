package com.hci.StarkIndustries.ui.Miniatures;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceMenuContainerFragment;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.DevicesRecyclerViewClickInteface;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewDevicesAdapter;

import java.util.ArrayList;
import java.util.List;

public class DevicesListFragment extends Fragment implements DevicesRecyclerViewClickInteface {

    private DevicesListViewModel mViewModel;

    public static DevicesListFragment newInstance(DevicesSelectionMode mode) {

        return new DevicesListFragment();
    }

    public static DevicesListFragment newInstance(String roomID) {
        return new DevicesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.devices_list_fragment, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2, RecyclerView.HORIZONTAL,false);
        RecyclerView recyclerView =  view.findViewById(R.id.RecyclerViewDevices);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewDevicesAdapter adapter = new RecyclerViewDevicesAdapter(this.getModels(),this,this.getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DevicesListViewModel.class);
        // TODO: Use the ViewModel
    }

    private List<CommonDeviceModel> getModels(){
        List<CommonDeviceModel> models = new ArrayList<>();

        models.add(new CommonDeviceModel("AC","id1","ROOM1", DeviceType.AC));
        models.add(new CommonDeviceModel("LAmp","id1","ROOM1", DeviceType.Lamp));
        models.add(new CommonDeviceModel("Door","id1","ROOM1", DeviceType.Door));
        models.add(new CommonDeviceModel("Device 4","id1","ROOM1", DeviceType.Speaker));
        models.add(new CommonDeviceModel("Device 5","id1","ROOM1", DeviceType.Speaker));

        return models;
    }


    @Override
    public void onItemClick(CommonDeviceModel device){
        DeviceMenuContainerFragment fragment = DeviceMenuContainerFragment.newInstance(device);
        fragment.show(getFragmentManager(),"fav");

    }
}
