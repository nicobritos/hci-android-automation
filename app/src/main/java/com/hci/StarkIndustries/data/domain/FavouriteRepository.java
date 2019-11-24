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

    public LiveData<Result<Boolean>> setFavourite(String id, JSONObject parsedObject, boolean value) {
        try {
            parsedObject.getJSONObject("meta").put("favourite", value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.updateMeta(id, parsedObject, getEntityType(), getListener(result), getErrorListener(api, result));
        return result;
    }

    protected abstract Api.APIEntityType getEntityType();
}
