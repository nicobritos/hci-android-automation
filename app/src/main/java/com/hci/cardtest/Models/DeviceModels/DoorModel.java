package com.hci.cardtest.Models.DeviceModels;

import com.hci.cardtest.Models.CommonDeviceModel;
import com.hci.cardtest.Models.DeviceType;

public class DoorModel extends CommonDeviceModel {

    public boolean isOpen;
    public boolean islocked;
    
    public DoorModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Door);
        islocked = false;
        isOpen = false;
    }
}
