package com.hci.StarkIndustries.data.Models.devices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
