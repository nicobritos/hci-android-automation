package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class CurtainsModel extends CommonDeviceModel {
    public String getStatus() {
        return this.getPropertyString("status");
    }

    public int getLevel() {
        return this.getPropertyInt("level");
    }
}
