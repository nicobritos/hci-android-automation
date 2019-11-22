package com.hci.StarkIndustries.ui.DeviceMenu;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;

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
                    Log.d("DDDDD", commonDeviceModelResult.getResult().getDeviceType().toString());
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
}
