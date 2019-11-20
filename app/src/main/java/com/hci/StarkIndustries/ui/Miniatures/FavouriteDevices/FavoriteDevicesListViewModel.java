package com.hci.StarkIndustries.ui.Miniatures.FavouriteDevices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.devices.DevicesListModel;
import com.hci.StarkIndustries.data.Models.devices.FavoriteDevicesModel;
import com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment.DevicesListViewModel;

public class FavoriteDevicesListViewModel extends DevicesListViewModel {
    @Override
    public LiveData<DevicesListModel> getModel() {
        if (mDeviceList == null) {
            mDeviceList = new MutableLiveData<>();
            model = new FavoriteDevicesModel();
            loadModel();
        }
        return mDeviceList;
    }
}
