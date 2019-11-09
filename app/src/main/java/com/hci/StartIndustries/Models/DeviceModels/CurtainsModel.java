package com.hci.StartIndustries.Models.DeviceModels;

import com.hci.StartIndustries.Models.CommonDeviceModel;
import com.hci.StartIndustries.Models.DeviceType;

public class CurtainsModel extends CommonDeviceModel {

    public boolean isOpen;

    public  CurtainsModel(String name, String id, String room, DeviceType type) {
        super(name, id, room, type);
        isOpen = true;
    }
}
