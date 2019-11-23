package com.hci.StarkIndustries.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.domain.RegionRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    public LiveData<Result<ArrayList<RegionModel>>> getModel() {
        return RegionRepository.get().getRegions();
    }
}
