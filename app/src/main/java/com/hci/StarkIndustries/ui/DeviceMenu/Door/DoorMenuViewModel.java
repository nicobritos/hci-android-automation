package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.DoorModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class DoorMenuViewModel extends DeviceViewModel<DoorModel> {
    private static final String TAG = "DoorMenuViewModel";

    public boolean open() {

        loadModel();
        return true;
    }

    public boolean close() {


//        model.isOpen = false;
        // Do stuff
        loadModel();
        return true;
    }

    public boolean lock() {


//        model.islocked = true;

        // Do stuff
        loadModel();
        return true;
    }

    public boolean unlock() {


//        model.islocked = false;

        // Do stuff
        loadModel();
        return true;
    }


}
