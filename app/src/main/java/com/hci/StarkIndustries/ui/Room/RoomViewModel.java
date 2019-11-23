package com.hci.StarkIndustries.ui.Room;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoomRepository;
import com.hci.StarkIndustries.ui.CommonViewModel;

public class RoomViewModel extends CommonViewModel<RoomModel> {
    @Override
    protected void loadModel() {
        RoomRepository.get().getRoomDevices(this.id).observe(this.lifecycleOwner, this::onModelLoad);
    }
}
