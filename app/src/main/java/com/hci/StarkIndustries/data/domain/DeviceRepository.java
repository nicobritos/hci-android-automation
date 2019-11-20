package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.remote.Api;

import java.util.ArrayList;

public class DeviceRepository {
    private static DeviceRepository instance;
    private final Api api;

    private DeviceRepository(Application application) {
        this.api = Api.getInstance(application);
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

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices() {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices(String roomId) {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(roomId, getListener(result), getErrorListener(api, result));
        return result;
    }

    private static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result) {
        return (response) -> result.setValue(new Result<>(response));
    }

    private static <T> Response.ErrorListener getErrorListener(final Api api, final MutableLiveData<Result<T>> result) {
        return (error) -> result.setValue(new Result<>(null, api.handleError(error)));
    }
}
