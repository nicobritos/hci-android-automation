package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class ACModel extends CommonDeviceModel {
    public boolean isPowered() {
        return this.equalsStatus("on");
    }

    public int getTemperature() {
        return this.getPropertyInt("temperature");
    }

    public String getMode() {
        return this.getPropertyString("mode");
    }

    public String getVerticalSwing() {
        return this.getPropertyString("verticalSwing");
    }

    public String getHorizontalSwing() {
        return this.getPropertyString("horizontalSwing");
    }

    public String getFanSpeed() {
        return this.getPropertyString("fanSpeed");
    }
}
