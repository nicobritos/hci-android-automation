package com.hci.StarkIndustries.data.Models.devices;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FavoriteDevicesModel extends DevicesListModel {
    public FavoriteDevicesModel() {

//        models.add(new CommonDeviceModel("AC","id1","ROOM1", DeviceType.AC,true));
//        models.add(new CommonDeviceModel("LAmp","id1","ROOM1", DeviceType.Lamp,true));
//        models.add(new CommonDeviceModel("Door","id1","ROOM1", DeviceType.Door,true));
//        models.add(new CommonDeviceModel("Speaker","id1","ROOM1", DeviceType.Speaker,true));
//        models.add(new CommonDeviceModel("Curtains","id1","ROOM1", DeviceType.Curtains,true));
//        models.add(new CommonDeviceModel("Fridge","id1","ROOM1", DeviceType.Fridge,true));
//        models.add(new CommonDeviceModel("Oven","id1","ROOM1", DeviceType.Oven,true));
    }

    @Override
    public List<CommonDeviceModel> filterDevices() {
        return models.stream().filter(new Predicate<CommonDeviceModel>() {
            @Override
            public boolean test(CommonDeviceModel deviceModel) {
                return deviceModel.isFavorite;
            }
        }).collect(Collectors.<CommonDeviceModel>toList());
    }
}
