package com.hci.StartIndustries.Models.DeviceModels;

import com.hci.StartIndustries.Models.DeviceType;
import com.hci.StartIndustries.Models.CommonDeviceModel;

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
