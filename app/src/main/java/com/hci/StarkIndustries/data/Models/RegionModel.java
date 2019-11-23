package com.hci.StarkIndustries.data.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionModel extends CommonModel {
    private List<RoomModel> rooms = new ArrayList<>();

    public List<RoomModel> getRooms() {
        return rooms;
    }

    public void addRooms(Collection<RoomModel> roomModels) {
        this.rooms.addAll(roomModels);
    }

    public void addRoom(RoomModel roomModel) {
        this.rooms.add(roomModel);
    }
}
