package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.DoorModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class DoorMenuViewModel extends DeviceViewModel<DoorModel> {
    private static final String TAG = "DoorMenuViewModel";

    public void open() {
        this.performActionOnDevice(DeviceRepository.DoorActions.OPEN.getCommand());
    }

    public void close() {
        this.performActionOnDevice(DeviceRepository.DoorActions.CLOSE.getCommand());
    }

    public void lock() {
        this.performActionOnDevice(DeviceRepository.DoorActions.LOCK.getCommand());
    }

    public void unlock() {
        this.performActionOnDevice(DeviceRepository.DoorActions.UNLOCK.getCommand());
    }
}
