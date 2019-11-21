package com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.devices.DevicesListModel;

import java.util.ArrayList;

public class DevicesListViewModel extends ViewModel {
    protected MutableLiveData<DevicesListModel> mDeviceList;
    protected DevicesListModel model;

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getModel() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    protected void loadModel() {
        mDeviceList.setValue(model);
    }
}
