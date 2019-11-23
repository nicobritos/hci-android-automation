package com.hci.StarkIndustries.ui;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.Result;

public abstract class CommonViewModel<T extends CommonModel> extends ViewModel {
    protected LifecycleOwner lifecycleOwner;
    protected MutableLiveData<T> mModel;
    protected String id;
    protected T model;

    public LiveData<T> getModel(LifecycleOwner lifecycleOwner, String id) {
        if (mModel == null || !model.getId().equalsIgnoreCase(id)) {
            mModel = new MutableLiveData<>();
            this.id = id;
            this.lifecycleOwner = lifecycleOwner;
            this.loadModel();
        }

        return mModel;
    }

    protected void onModelLoad(Result<? extends CommonModel> result) {
        if (result.ok()) {
            //noinspection unchecked
            model = (T) result.getResult();
        } else {
            model = null;
        }
    }

    protected abstract void loadModel();

    protected Void reloadModelCallback(Result<Boolean> result) {
        if (result.ok() && result.getResult()) loadModel();
        return null;
    }
}
