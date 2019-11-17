package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.DeviceType;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class FridgeModel extends CommonDeviceModel {
    public String getMode() {
        return this.getPropertyString("mode");
    }

    public int getTemperature() {
        return this.getPropertyInt("temperature");
    }

    public int getFreezerTemperature() {
        return this.getPropertyInt("freezerTemperature");
    }
}
