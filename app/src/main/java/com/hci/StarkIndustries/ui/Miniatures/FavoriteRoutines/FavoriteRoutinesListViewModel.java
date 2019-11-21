package com.hci.StarkIndustries.ui.Miniatures.FavoriteRoutines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.FavoriteRoutinesListModel;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.Models.RoutinesListModel;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoutineRepository;
import com.hci.StarkIndustries.ui.Miniatures.Routines.RoutinesListViewModel;

import java.util.ArrayList;

public class FavoriteRoutinesListViewModel extends RoutinesListViewModel {
    @Override
    public LiveData<Result<ArrayList<RoutineModel>>> getModel() {
        return RoutineRepository.get().getFavouriteRoutines();
    }
}
