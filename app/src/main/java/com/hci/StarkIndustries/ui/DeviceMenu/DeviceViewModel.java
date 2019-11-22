package com.hci.StarkIndustries.ui.DeviceMenu;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;

import java.util.function.Function;

public abstract class DeviceViewModel<T extends CommonDeviceModel> extends ViewModel {
    protected LifecycleOwner lifecycleOwner;
    protected MutableLiveData<T> mModel;
    protected T model;

    public LiveData<T> getModel(LifecycleOwner lifecycleOwner, String id) {
        if (mModel == null || !model.getId().equalsIgnoreCase(id)) {
            mModel = new MutableLiveData<>();

            this.lifecycleOwner = lifecycleOwner;
            DeviceRepository.get().getDevice(id).observe(lifecycleOwner, commonDeviceModelResult -> {
                if (commonDeviceModelResult.ok()) {
                    //noinspection unchecked
                    model = (T) commonDeviceModelResult.getResult();
                } else {
                    model = null;
                }
                loadModel();
            });
        }

        return mModel;
    }

    protected void loadModel() {
        mModel.setValue(model);
    }

    protected LiveData<Result<Boolean>> performActionOnDevice(String actionId) {
        return this.performActionOnDevice(actionId, null, null, this::reloadModelCallback);
    }

    protected LiveData<Result<Boolean>> performActionOnDevice(String actionId, Function<Result<Boolean>, Void> callback) {
        return this.performActionOnDevice(actionId, null, null, callback);
    }

    protected LiveData<Result<Boolean>> performActionOnDevice(String actionId, String key, String value) {
        return this.performActionOnDevice(actionId, key, value, this::reloadModelCallback);
    }

    protected LiveData<Result<Boolean>> performActionOnDevice(String actionId, String key, String value, Function<Result<Boolean>, Void> callback) {
        LiveData<Result<Boolean>> resultLiveData = DeviceRepository.get().performActionOnDevice(
                model.getId(),
                actionId,
                key,
                value
        );
        resultLiveData.observe(this.lifecycleOwner, callback::apply);
        return resultLiveData;
    }

    private Void reloadModelCallback(Result<Boolean> result) {
        if (result.ok() && result.getResult()) loadModel();
        return null;
    }
}
