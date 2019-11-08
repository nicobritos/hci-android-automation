package com.hci.cardtest.Models.DeviceModels;

import com.hci.cardtest.Models.CommonDeviceModel;
import com.hci.cardtest.Models.DeviceType;

public class FridgeModel extends CommonDeviceModel {
    public FridgeModel(String name, String id, String room) {




        super(name, id, room, DeviceType.Fridge);
    }
}
