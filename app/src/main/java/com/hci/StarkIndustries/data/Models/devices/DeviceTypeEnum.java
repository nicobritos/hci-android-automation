package com.hci.StarkIndustries.data.Models.devices;

import java.util.Arrays;

public enum DeviceTypeEnum {
    Door("lsf78ly0eqrjbz91"),
    Speaker("c89b94e8581855bc"),
    Fridge("rnizejqr2di0okho"),
    Curtains("eu0v2xgprrhhg41g"),
    Lamp("go46xmbqeomjrsjr"),
    AC("li6cbv5sdlatti0j"),
    Oven("im77xxyulpegfmv8");

    private String id;

    DeviceTypeEnum(String id) {
        this.id = id;
    }

    public static DeviceTypeEnum getDeviceTypeEnumFromId(String id) {
        return Arrays.stream(DeviceTypeEnum.values())
                .filter(deviceTypeEnum -> deviceTypeEnum.id.equals(id))
                .findFirst()
                .orElse(null);
    }
}
