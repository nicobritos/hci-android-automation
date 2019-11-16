package com.hci.StarkIndustries.data.Models.DeviceModels;

import com.hci.StarkIndustries.data.Models.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.DeviceType;

public class CurtainsModel extends CommonDeviceModel {

    public boolean isOpen;

    public  CurtainsModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Curtains,false);
        isOpen = true;
    }
}
