package com.hci.StarkIndustries.data.Models.devices;

import android.os.Parcel;
import android.os.Parcelable;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.RoomModel;

public class CommonDeviceModel extends CommonModel implements Parcelable {
    public static final Creator<CommonDeviceModel> CREATOR = new Creator<CommonDeviceModel>() {
        @Override
        public CommonDeviceModel createFromParcel(Parcel in) {
//            return new CommonDeviceModel(in);
            return new CommonDeviceModel();
        }

        @Override
        public CommonDeviceModel[] newArray(int size) {
            return new CommonDeviceModel[size];
        }
    };

    private DeviceType type;
    private RoomModel room;
    private String name;

//    private CommonDeviceModel(Parcel in) {
//        this.setName(in.readString());
////        Room = in.readString();
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
//        dest.writeString(Room);
    }

    public RoomModel getRoom() {
        return room;
    }

    public DeviceTypeEnum getDeviceType() {
        return type.getDeviceType();
    }
}
