package com.hci.StarkIndustries.Models.DeviceModels;

import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.Models.CommonDeviceModel;

public class FridgeModel extends CommonDeviceModel {

    public int temperature;
    public int freezerTemperature;
    public int mode;


    public FridgeModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Fridge);
        temperature = 6;
        freezerTemperature = -10;
        mode = 1;
    }
}
