package com.hci.StarkIndustries.Models.DeviceModels;

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;

public class CurtainsModel extends CommonDeviceModel {

    public boolean isOpen;

    public  CurtainsModel(String name, String id, String room, DeviceType type) {
        super(name, id, room, type);
        isOpen = true;
    }
}
