package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoomModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomRepository extends CommonRepository {
    private static RoomRepository instance;

    private RoomRepository(Application application) {
        super(application);
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

    public LiveData<Result<RoomModel>> getRoomDevices(String id) {
        final MutableLiveData<Result<RoomModel>> result = new MutableLiveData<>();
        this.api.getRoomDevices(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoomModel>>> getRooms() {
        final MutableLiveData<Result<ArrayList<RoomModel>>> result = new MutableLiveData<>();
        this.api.getRooms(getListener(result, roomModels -> {
            return roomModels.stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new));
        }), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoomModel>>> getRooms(String regionId) {
        final MutableLiveData<Result<ArrayList<RoomModel>>> result = new MutableLiveData<>();
        this.api.getRooms(regionId, getListener(result, roomModels -> {
            return roomModels.stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new));
        }), getErrorListener(api, result));
        return result;
    }
}
