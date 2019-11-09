package com.hci.StarkIndustries.Models.DeviceModels;

import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.Models.CommonDeviceModel;

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
