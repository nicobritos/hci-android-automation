package com.hci.StarkIndustries.data.Models;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomModel extends CommonModel {
    private List<CommonDeviceModel> devices;
    private Map<String, String> region;

    public String getRegionId() {
        return this.region != null ? this.region.get("id") : null;
    }

    public String getRegionName() {
        return this.region != null ? this.region.get("name") : null;
    }

    public int getDevicesCount() {
        return this.meta != null ? (int) this.meta.get("count") : 0;
    }

    public Collection<CommonDeviceModel> getDevices() {
        createDevices();
        return devices;
    }

    public void addDevice(CommonDeviceModel deviceModel) {
        createDevices();
        this.devices.add(deviceModel);
    }

    public void addDevices(Collection<CommonDeviceModel> deviceModels) {
        createDevices();
        this.devices.addAll(deviceModels);
    }

    private void createDevices() {
        if (this.devices == null) this.devices = new LinkedList<>();
    }
}
