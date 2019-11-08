package com.hci.cardtest.Models.DeviceModels;

import androidx.lifecycle.LiveData;

import com.hci.cardtest.Models.CommonDeviceModel;
import com.hci.cardtest.Models.DeviceType;

public class CurtainsModel extends CommonDeviceModel {

    public boolean isOpen;

    public  CurtainsModel(String name, String id, String room, DeviceType type) {
        super(name, id, room, type);
        isOpen = true;
    }
}
