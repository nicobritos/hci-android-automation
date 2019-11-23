package com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.CommonViewModel;

import java.util.ArrayList;

public class DevicesListViewModel extends ViewModel {
    public LiveData<Result<ArrayList<CommonDeviceModel>>> getModel() {
        return DeviceRepository.get().getDevices();
    }
}
