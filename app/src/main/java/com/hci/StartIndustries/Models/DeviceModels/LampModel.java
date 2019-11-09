package com.hci.StartIndustries.Models.DeviceModels;

import com.hci.StartIndustries.Models.DeviceType;
import com.hci.StartIndustries.Models.CommonDeviceModel;

public class LampModel extends CommonDeviceModel {


    public int color;
    public int intensity;
    public boolean isOn;


    public LampModel(String name, String id, String room, DeviceType type) {
        super(name, id, room, type);

        isOn = false;
        intensity = 50;
        color = 0x0;
    }
}
