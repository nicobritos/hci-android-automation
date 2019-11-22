package com.hci.StarkIndustries.data.Models.devices;

import android.os.Parcel;
import android.os.Parcelable;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.FavouriteCommonModel;
import com.hci.StarkIndustries.data.Models.RoomModel;

public class CommonDeviceModel extends FavouriteCommonModel {
    private DeviceType type;
    private RoomModel room;

    public RoomModel getRoom() {
        return room;
    }

    public DeviceTypeEnum getDeviceType() {
        return type.getDeviceType();
    }
}
