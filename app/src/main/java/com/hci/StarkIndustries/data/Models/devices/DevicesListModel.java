package com.hci.StarkIndustries.data.Models.devices;

import java.util.ArrayList;
import java.util.List;

public abstract class DevicesListModel {
    protected List<CommonDeviceModel> models = new ArrayList<>();

    public DevicesListModel() {
        throw new IllegalArgumentException();
    }

    public abstract List<CommonDeviceModel> filterDevices();

    public List<CommonDeviceModel> getDevices() {
        return filterDevices();
    }
}
