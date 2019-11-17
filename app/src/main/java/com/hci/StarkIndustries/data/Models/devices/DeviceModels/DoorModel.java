package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.DeviceType;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class DoorModel extends CommonDeviceModel {
    public String getStatus() {
        return this.getPropertyString("status");
    }

    public boolean isLocked() {
        String s = this.getPropertyString("lock");
        return s != null && s.equalsIgnoreCase("locked");
    }
}
