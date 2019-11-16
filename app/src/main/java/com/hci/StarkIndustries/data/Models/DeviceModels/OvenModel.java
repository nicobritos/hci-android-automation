package com.hci.StarkIndustries.data.Models.DeviceModels;

import com.hci.StarkIndustries.data.Models.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.DeviceType;

public class OvenModel extends CommonDeviceModel {

    public Boolean isOn = true;
    public int temperature = 150;
    public int heatSource =1;
    public int grillMode=2;
    public int convectionMode=1;

    public OvenModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Oven,false);
    }
}
