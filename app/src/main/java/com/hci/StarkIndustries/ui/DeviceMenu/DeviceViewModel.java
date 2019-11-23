package com.hci.StarkIndustries.ui.DeviceMenu;

import androidx.lifecycle.LiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.FavouriteRepository;
import com.hci.StarkIndustries.ui.FavouritableCommonViewModel;

import java.util.function.Function;

public abstract class DeviceViewModel<T extends CommonDeviceModel> extends FavouritableCommonViewModel<T> {
    @Override
    protected void loadModel() {
        DeviceRepository.get().getDevice(this.id).observe(this.lifecycleOwner, this::onModelLoad);
    }

    protected LiveData<Result<Object>> performActionOnDevice(String actionId) {
        return this.performActionOnDevice(actionId, null, null, this::reloadModelCallback);
    }

    protected LiveData<Result<Object>> performActionOnDevice(String actionId, Function<Result<Object>, Void> callback) {
        return this.performActionOnDevice(actionId, null, null, callback);
    }

    protected <R> LiveData<Result<Object>> performActionOnDevice(String actionId, String key, R value) {
        return this.performActionOnDevice(actionId, key, value, this::reloadModelCallback);
    }

    protected <R> LiveData<Result<Object>> performActionOnDevice(String actionId, String key, R value, Function<Result<Object>, Void> callback) {
        LiveData<Result<Object>> resultLiveData = DeviceRepository.get().performActionOnDevice(
                model.getId(),
                actionId,
                key,
                value
        );
        resultLiveData.observe(this.lifecycleOwner, callback::apply);
        return resultLiveData;
    }

    @Override
    protected FavouriteRepository getRepository() {
        return DeviceRepository.get();
    }
}
