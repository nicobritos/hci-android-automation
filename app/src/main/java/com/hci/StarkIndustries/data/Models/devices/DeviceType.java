package com.hci.StarkIndustries.data.Models.devices;


public class DeviceType {
    private String id;

    public DeviceTypeEnum getDeviceType() {
        return DeviceTypeEnum.getDeviceTypeEnumFromId(this.id);
    }
}
