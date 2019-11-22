package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DeviceRepository extends CommonRepository {
    private static DeviceRepository instance;

    private DeviceRepository(Application application) {
        super(application);
    }

    public static synchronized DeviceRepository get() {
        return instance;
    }

    public static synchronized DeviceRepository create(Application application) {
        if (instance == null) {
            instance = new DeviceRepository(application);
        }
        return instance;
    }

    public LiveData<Result<CommonDeviceModel>> getDevice(String id) {
        final MutableLiveData<Result<CommonDeviceModel>> result = new MutableLiveData<>();
        this.api.getDevice(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<Boolean>> performActionOnDevice(String id, String actionId, JSONObject payload) {
        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.performActionOnDevice(id, actionId, payload, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices() {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getFavouriteDevices() {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();

        this.api.getDevices(
                getListener(result, commonDeviceModels -> {
                    return commonDeviceModels.stream().filter(CommonDeviceModel::isFavourite).collect(Collectors.toCollection(ArrayList::new));
                }),
                getErrorListener(api, result)
        );

        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices(String roomId) {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(roomId, getListener(result), getErrorListener(api, result));
        return result;
    }
}
