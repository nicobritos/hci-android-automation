package com.hci.StarkIndustries.ui.Miniatures.BaseDeviceFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DevicesListModel;

public class DevicesListViewModel extends ViewModel {

    protected MutableLiveData<DevicesListModel> mDeviceList;
    protected DevicesListModel model;

    public LiveData<DevicesListModel> getModel(){
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    protected void loadModel() {
        mDeviceList.setValue(model);
    }


    public void remove(int pos){
        // Implement
    }


    // TODO: Implement the ViewModel
}
