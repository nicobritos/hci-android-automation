package com.hci.StarkIndustries.data.Models.devices;

import java.util.List;

public class RoomDevicesModel extends DevicesListModel {
    private String Room;

    public RoomDevicesModel(String room) {
        super();
    }

    @Override
    public List<CommonDeviceModel> filterDevices() {
        //                return deviceModel.Room == Room;
        return models;
    }
}
