package com.hci.StarkIndustries.data.Models.devices;

import android.os.Parcel;
import android.os.Parcelable;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.RoomModel;

import org.json.JSONObject;

import java.util.Map;

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

    private Map<String, Object> state;
    private RoomModel room;
    private DeviceType type;

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

    protected boolean equalsStatus(String status) {
        String s = this.getPropertyString("status");
        if (s != null) return s.equalsIgnoreCase(status);
        return false;
    }

    protected Map getPropertyMap(String property) {
        Object o = state.get(property);
        if (o instanceof Map) return (Map) o;
        return null;
    }

    protected int getPropertyInt(String property) {
        Object o = state.get(property);
        if (o instanceof Integer) return (int) o;
        return 0;
    }

    protected boolean getPropertyBoolean(String property) {
        Object o = state.get(property);
        if (o instanceof Boolean) return (Boolean) o;
        return false;
    }

    protected String getPropertyString(String property) {
        Object o = state.get(property);
        if (o instanceof String) return (String) o;
        return null;
    }

    protected Object getProperty(String property) {
        return state.get(property);
    }
}
