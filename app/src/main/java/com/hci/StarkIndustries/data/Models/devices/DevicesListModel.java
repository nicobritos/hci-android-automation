package com.hci.StarkIndustries.data.Models.devices;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleService;

import com.hci.StarkIndustries.data.domain.DeviceRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class DevicesListModel {
    protected List<CommonDeviceModel> models = new ArrayList<>();

    public DevicesListModel() {
//        DeviceRepository.get().getDevices().observe();
//        models.add(new CommonDeviceModel("AC","id1","ROOM1", DeviceType.AC,true));
//        models.add(new CommonDeviceModel("LAmp","id1","ROOM1", DeviceType.Lamp,true));
//        models.add(new CommonDeviceModel("Door","id1","ROOM1", DeviceType.Door,true));
//        models.add(new CommonDeviceModel("Speaker","id1","ROOM1", DeviceType.Speaker,true));
//        models.add(new CommonDeviceModel("Curtains","id1","ROOM1", DeviceType.Curtains,true));
//        models.add(new CommonDeviceModel("Fridge","id1","ROOM1", DeviceType.Fridge,true));
//        models.add(new CommonDeviceModel("Oven","id1","ROOM1", DeviceType.Oven,true));
    }

    public abstract List<CommonDeviceModel> filterDevices();

    public List<CommonDeviceModel> getDevices(){
        return filterDevices();
    }
}
