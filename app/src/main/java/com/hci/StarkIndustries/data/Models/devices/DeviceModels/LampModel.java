package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.DeviceType;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class LampModel extends CommonDeviceModel {
    public String getColor() {
        return this.getPropertyString("color");
    }

    public boolean isPowered() {
        return this.equalsStatus("on");
    }

    public int getBrightness() {
        return this.getPropertyInt("brightness");
    }
}
