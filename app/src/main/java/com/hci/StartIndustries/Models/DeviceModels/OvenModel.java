package com.hci.StartIndustries.Models.DeviceModels;

import com.hci.StartIndustries.Models.CommonDeviceModel;
import com.hci.StartIndustries.Models.DeviceType;

public class OvenModel extends CommonDeviceModel {

    public Boolean isOn = true;
    public int temperature = 150;
    public int heatSource =1;
    public int grillMode=2;
    public int convectionMode=1;

    public OvenModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Oven);
    }
}
