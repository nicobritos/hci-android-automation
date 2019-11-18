package com.hci.StarkIndustries.Models;

import java.util.ArrayList;
import java.util.List;

public class RegionModel {
    public String id;
    public List<RoomModel> rooms = new ArrayList<>();
    public String name;

    public RegionModel(String name) {
        this.name = name;
        this.id = name;

        rooms.add(new RoomModel("Cuarto1"));
        rooms.add(new RoomModel("Cuarto2"));
        rooms.add(new RoomModel("Cuarto3"));
        rooms.add(new RoomModel("Cuarto4"));
    }
}
