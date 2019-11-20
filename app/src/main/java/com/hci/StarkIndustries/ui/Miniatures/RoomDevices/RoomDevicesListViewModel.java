package com.hci.StarkIndustries.ui.Miniatures.RoomDevices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.devices.DevicesListModel;
import com.hci.StarkIndustries.data.Models.devices.RoomDevicesModel;
import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListViewModel;

public class RoomDevicesListViewModel extends DevicesListViewModel {

    protected String id = "";

    public void SetID(String id) {
        this.id = id;
    }

    @Override
    public LiveData<DevicesListModel> getModel() {

        if (mDeviceList == null) {
            mDeviceList = new MutableLiveData<>();
            model = new RoomDevicesModel(this.id);
            loadModel();
        }
        return mDeviceList;
    }
}
