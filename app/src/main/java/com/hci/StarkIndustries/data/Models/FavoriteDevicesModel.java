package com.hci.StarkIndustries.data.Models;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FavoriteDevicesModel extends DevicesListModel {
    @Override
    public List<CommonDeviceModel> filterDevices() {
        return models.stream().filter(new Predicate<CommonDeviceModel>() {
            @Override
            public boolean test(CommonDeviceModel deviceModel) {
                return deviceModel.isFavorite;
            }
        }).collect(Collectors.<CommonDeviceModel>toList());
    }
}
