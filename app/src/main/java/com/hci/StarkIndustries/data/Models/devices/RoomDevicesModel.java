package com.hci.StarkIndustries.data.Models.devices;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomDevicesModel extends DevicesListModel {
    private String Room;
    public RoomDevicesModel(String room) {
        super();
        this.Room = room;
    }

    @Override
    public List<CommonDeviceModel> filterDevices() {
        return models.stream().filter(new Predicate<CommonDeviceModel>() {
            @Override
            public boolean test(CommonDeviceModel deviceModel) {
//                return deviceModel.Room == Room;
                return true;
            }
        }).collect(Collectors.<CommonDeviceModel>toList());
    }
}
