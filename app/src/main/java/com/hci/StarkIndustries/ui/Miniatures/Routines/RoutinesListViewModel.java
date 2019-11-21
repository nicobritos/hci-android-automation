package com.hci.StarkIndustries.ui.Miniatures.Routines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.Models.RoutinesListModel;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoutineRepository;

import java.util.ArrayList;

public class RoutinesListViewModel extends ViewModel {
    protected MutableLiveData<RoutinesListModel> mRoutine;
    protected RoutinesListModel model;

    public LiveData<Result<ArrayList<RoutineModel>>> getModel() {
        return RoutineRepository.get().getRoutines();
    }

    protected void loadModel() {
        mRoutine.setValue(model);
    }
}
