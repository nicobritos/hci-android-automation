package com.hci.StartIndustries.Models.DeviceModels;

import com.hci.StartIndustries.Models.DeviceType;
import com.hci.StartIndustries.Models.CommonDeviceModel;

public class DoorModel extends CommonDeviceModel {

    public boolean isOpen;
    public boolean islocked;
    
    public DoorModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Door);
        islocked = false;
        isOpen = false;
    }
}
