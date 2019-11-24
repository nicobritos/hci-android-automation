package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.remote.Api;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoutineRepository extends FavouriteRepository {
    private static RoutineRepository instance;

    private RoutineRepository(Application application) {
        super(application);
    }

    public static synchronized RoutineRepository get() {
        return instance;
    }

    public static synchronized RoutineRepository create(Application application) {
        if (instance == null) {
            instance = new RoutineRepository(application);
        }
        return instance;
    }

    public LiveData<Result<Boolean>> executeRoutine(String id) {
        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.executeRoutine(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<RoutineModel>> getRoutine(String id) {
        final MutableLiveData<Result<RoutineModel>> result = new MutableLiveData<>();
        this.api.getRoutine(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoutineModel>>> getRoutines() {
        final MutableLiveData<Result<ArrayList<RoutineModel>>> result = new MutableLiveData<>();
        this.api.getRoutines(getListener(result, routineModels -> {
            return routineModels.stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new));
        }), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RoutineModel>>> getFavouriteRoutines() {
        final MutableLiveData<Result<ArrayList<RoutineModel>>> result = new MutableLiveData<>();

        this.api.getRoutines(
                getListener(result, routineModels -> {
                    return routineModels.stream()
                            .filter(RoutineModel::isFavourite)
                            .sorted()
                            .collect(Collectors.toCollection(ArrayList::new));
                }),
                getErrorListener(api, result)
        );

        return result;
    }

    @Override
    protected Api.APIEntityType getEntityType() {
        return Api.APIEntityType.ROUTINE;
    }
}
