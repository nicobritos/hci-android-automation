package com.hci.StarkIndustries.data.domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.data.Models.Result;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RegionRepository extends CommonRepository {
    private static RegionRepository instance;

    private RegionRepository(Application application) {
        super(application);
    }

    public static synchronized RegionRepository get() {
        return instance;
    }

    public static synchronized RegionRepository create(Application application) {
        if (instance == null) {
            instance = new RegionRepository(application);
        }
        return instance;
    }

    public LiveData<Result<RegionModel>> getRegion(String id) {
        final MutableLiveData<Result<RegionModel>> result = new MutableLiveData<>();
        this.api.getRegion(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<RegionModel>>> getRegions() {
        final MutableLiveData<Result<ArrayList<RegionModel>>> result = new MutableLiveData<>();
        this.api.getRegions(getListener(result, regionModels -> {
            return regionModels.stream()
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new));
        }), getErrorListener(api, result));
        return result;
    }
}
