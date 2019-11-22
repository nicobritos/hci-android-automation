package com.hci.StarkIndustries.data.Models;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.RoomModel;

import java.util.ArrayList;
import java.util.List;

public class RegionModel extends CommonModel {
    public String id;
    public List<RoomModel> rooms = new ArrayList<>();
    public String name;

    public RegionModel(String name) {
        this.name = name;
        this.id = name;
//
//        rooms.add(new RoomModel("ROOM1"));
//        rooms.add(new RoomModel("ROOM2"));
//        rooms.add(new RoomModel("ROOM3"));
//        rooms.add(new RoomModel("ROOM4"));
    }
}
