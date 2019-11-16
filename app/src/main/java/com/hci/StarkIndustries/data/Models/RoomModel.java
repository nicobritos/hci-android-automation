package com.hci.StarkIndustries.data.Models;

import android.util.Log;

public class RoomModel extends CommonModel {
    public String name;
    public String id;

    public RoomModel(String id, String name, String meta, String els) {
        super(id, name, meta);
        Log.println(Log.INFO, "com.hci", els);

        this.id = id;
        this.name =id;
    }
}
