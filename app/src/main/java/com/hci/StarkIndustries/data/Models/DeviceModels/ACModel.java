package com.hci.StarkIndustries.data.Models.DeviceModels;

import com.hci.StarkIndustries.data.Models.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.DeviceType;

public class ACModel extends CommonDeviceModel {

    public boolean power = true;
    public int temperature = 22;
    public int mode = 2;
    public int verticalMov = 1;
    public int horizontalMov = 0;
    public int fanSpeed = 3;


    public ACModel(String name, String id, String room) {
        super(name, id, room, DeviceType.AC,false);
    }
}
