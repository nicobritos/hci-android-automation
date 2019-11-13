package com.hci.StarkIndustries.Models;

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DevicesListModel;

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
                return deviceModel.Room == Room;
            }
        }).collect(Collectors.<CommonDeviceModel>toList());
    }
}
