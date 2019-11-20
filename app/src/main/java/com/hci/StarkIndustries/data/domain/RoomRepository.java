package com.hci.StarkIndustries.data.domain;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;

import java.util.ArrayList;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.data.remote.Api;

public class RoomRepository {
    private static RoomRepository instance;
    private final Api api;

    private RoomRepository(Application application) {
        this.api = Api.getInstance(application);
    }

    public static synchronized RoomRepository get() {
        return instance;
    }

    public static synchronized RoomRepository create(Application application) {
        if (instance == null) {
            instance = new RoomRepository(application);
        }
        return instance;
    }

    public LiveData<Result<RoomModel>> getRoom(String id) {
        final MutableLiveData<Result<RoomModel>> result = new MutableLiveData<>();
        this.api.getRoom(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoomModel>>> getRooms() {
        final MutableLiveData<Result<ArrayList<RoomModel>>> result = new MutableLiveData<>();
        this.api.getRooms(getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoomModel>>> getRooms(String regionId) {
        final MutableLiveData<Result<ArrayList<RoomModel>>> result = new MutableLiveData<>();
        this.api.getRooms(regionId, getListener(result), getErrorListener(api, result));
        return result;
    }

    private static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result) {
        return (response) -> result.setValue(new Result<>(response));
    }

    private static <T> Response.ErrorListener getErrorListener(final Api api, final MutableLiveData<Result<T>> result) {
        return (error) -> result.setValue(new Result<>(null, api.handleError(error)));
    }
}
