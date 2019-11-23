package com.hci.StarkIndustries.ui;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.CommonModel;
import com.hci.StarkIndustries.data.Models.Result;

public abstract class CommonViewModel<T> extends ViewModel {
    protected LifecycleOwner lifecycleOwner;
    protected MutableLiveData<T> mModel;
    protected String id;
    protected T model;

    public LiveData<T> getModel(LifecycleOwner lifecycleOwner, String id) {
        if (mModel == null || (model instanceof CommonModel && !((CommonModel) model).getId().equalsIgnoreCase(id))) {
            mModel = new MutableLiveData<>();
            this.id = id;
            this.lifecycleOwner = lifecycleOwner;
            this.loadModel();
        }

        return mModel;
    }

    protected void onModelLoad(Result<? super T> result) {
        if (result.ok()) {
            //noinspection unchecked
            model = (T) result.getResult();
        } else {
            model = null;
        }
    }

    protected abstract void loadModel();

    protected <R> Void reloadModelCallback(Result<R> result) {
        if (result.ok()) loadModel();
        else Log.d("CommonViewModel", result.getError().getDescription());
        return null;
    }
}
