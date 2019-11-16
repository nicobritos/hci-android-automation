package com.hci.StarkIndustries.data.Models.DeviceModels;

import com.hci.StarkIndustries.data.Models.DeviceType;
import com.hci.StarkIndustries.data.Models.CommonDeviceModel;

public class LampModel extends CommonDeviceModel {


    public int color;
    public int intensity;
    public boolean isOn;


    public LampModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Lamp,false);

        isOn = false;
        intensity = 50;
        color = 0xF012DA;
    }
}
