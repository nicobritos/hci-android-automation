package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceType;

public class OvenModel extends CommonDeviceModel {
    public String getHeatMode() {
        return this.getPropertyString("heat");
    }

    public boolean isPowered() {
        return this.equalsStatus("on");
    }

    public boolean isGrilling() {
        String s = this.getPropertyString("grill");
        return s != null && s.equalsIgnoreCase("on");
    }

    public boolean usingConvection() {
        String s = this.getPropertyString("convection");
        return s != null && s.equalsIgnoreCase("on");
    }

    public int getTemperature() {
        return this.getPropertyInt("temperature");
    }
}
