package com.hci.StarkIndustries.ui.Miniatures.RoomDevices;

import androidx.lifecycle.LiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListViewModel;

import java.util.ArrayList;

public class RoomDevicesListViewModel extends DevicesListViewModel {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public LiveData<Result<ArrayList<CommonDeviceModel>>> getModel() {
        return DeviceRepository.get().getDevices(this.id);
    }
}
