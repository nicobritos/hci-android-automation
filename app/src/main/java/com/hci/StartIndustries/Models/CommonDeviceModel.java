package com.hci.StartIndustries.Models;

public class CommonDeviceModel {
    public CommonDeviceModel(String name, String id, String room, DeviceType type) {
        Name = name;
        Id = id;
        Room = room;
        this.type = type;
    }

    public String Name;
    public String Id;
    public String Room;
    public DeviceType type;

}
