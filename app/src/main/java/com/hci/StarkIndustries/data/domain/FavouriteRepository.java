package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.remote.Api;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FavouriteRepository extends CommonRepository {
    private static final String TAG = "FavouriteRepository";

    protected FavouriteRepository(Application application) {
        super(application);
    }

    public LiveData<Result<Boolean>> setFavourite(String id, String name, JSONObject meta, boolean value) {
        try {
            if (value) meta.put("favourite", true);
            else meta.put("favourite", false);
        } catch (JSONException e) {
            return null;
        }

        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.updateMeta(id, name, meta, getEntityType(), getListener(result), getErrorListener(api, result));
        return result;
    }

    protected abstract Api.APIEntityType getEntityType();
}
