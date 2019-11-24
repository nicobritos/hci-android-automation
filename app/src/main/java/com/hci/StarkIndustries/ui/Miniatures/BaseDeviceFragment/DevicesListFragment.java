package com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceMenuContainerFragment;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.DevicesRecyclerViewClickInteface;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewDevicesAdapter;

import java.util.ArrayList;

public abstract class DevicesListFragment extends Fragment implements DevicesRecyclerViewClickInteface {
    protected DevicesListViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.devices_list_fragment, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2, RecyclerView.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerViewDevices);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewDevicesAdapter adapter = new RecyclerViewDevicesAdapter(this, this.getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadViewModel();
        mViewModel.getModel().observe(this, deviceModelsResult -> {
            RecyclerView recyclerView = getView().findViewById(R.id.RecyclerViewDevices);

            if (deviceModelsResult.ok()) {
                ((RecyclerViewDevicesAdapter) recyclerView.getAdapter()).setData(deviceModelsResult.getResult());
                if (deviceModelsResult.getResult().size() == 0) {
                    getView().findViewById(R.id.NoDevicesView).setVisibility(View.VISIBLE);
                } else {
                    getView().findViewById(R.id.NoDevicesView).setVisibility(View.GONE);
                }
            } else {
                // TODO: ERROR
                getView().findViewById(R.id.NoDevicesView).setVisibility(View.VISIBLE);
            }
        });
    }

    public void ReloadElements(){
        Result<ArrayList<CommonDeviceModel>>temp = mViewModel.getModel().getValue();
        RecyclerView recyclerView = getView().findViewById(R.id.RecyclerViewDevices);
        ArrayList<CommonDeviceModel> arr = new ArrayList<>();

        if (temp != null && temp.ok()) {
            arr = temp.getResult();
        }
            ((RecyclerViewDevicesAdapter) recyclerView.getAdapter()).setData(arr);
            if (arr.size() == 0) {
                getView().findViewById(R.id.NoDevicesView).setVisibility(View.VISIBLE);
            } else {
                getView().findViewById(R.id.NoDevicesView).setVisibility(View.GONE);
            }



    }

    public void LoadViewModel() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    protected int getOrientation() {
        return RecyclerView.HORIZONTAL;
    }

    @Override
    public void onItemClick(CommonDeviceModel device) {
        DeviceMenuContainerFragment fragment = DeviceMenuContainerFragment.newInstance(device);
        fragment.show(getFragmentManager(), "fav");
    }
}
