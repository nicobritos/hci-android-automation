package com.hci.StarkIndustries.data.Models.DeviceModels;

import com.hci.StarkIndustries.data.Models.DeviceType;
import com.hci.StarkIndustries.data.Models.CommonDeviceModel;

public class DoorModel extends CommonDeviceModel {

    public boolean isOpen;
    public boolean islocked;
    
    public DoorModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Door,false);
        islocked = false;
        isOpen = false;
    }
}
