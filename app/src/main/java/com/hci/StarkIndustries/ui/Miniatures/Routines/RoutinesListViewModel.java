package com.hci.StarkIndustries.ui.Miniatures.Routines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.domain.RoutineRepository;

import java.util.ArrayList;

public class RoutinesListViewModel extends ViewModel {
    public LiveData<Result<ArrayList<RoutineModel>>> getModel() {
        return RoutineRepository.get().getRoutines();
    }
}
