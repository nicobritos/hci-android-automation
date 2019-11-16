package com.hci.StarkIndustries.data.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonDeviceModel implements Parcelable {
    public CommonDeviceModel(String name, String id, String room, DeviceType type,boolean isFavorite) {
        Name = name;
        Id = id;
        Room = room;
        this.type = type;
        this.isFavorite = isFavorite;
    }


    public boolean isFavorite;
    public String Name;
    public String Id;
    public String Room;
    public DeviceType type;

    protected CommonDeviceModel(Parcel in) {
        Name = in.readString();
        Id = in.readString();
        Room = in.readString();
    }

    public static final Creator<CommonDeviceModel> CREATOR = new Creator<CommonDeviceModel>() {
        @Override
        public CommonDeviceModel createFromParcel(Parcel in) {
            return new CommonDeviceModel(in);
        }

        @Override
        public CommonDeviceModel[] newArray(int size) {
            return new CommonDeviceModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Id);
        dest.writeString(Room);
    }
}
