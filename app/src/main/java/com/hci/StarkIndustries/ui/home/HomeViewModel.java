package com.hci.StarkIndustries.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.RegionModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<RegionModel>> mData;

    private List<RegionModel> regions =  new ArrayList<>();


    public LiveData<List<RegionModel>> getModels(){
        if(mData == null){
            mData = new MutableLiveData<>();
            regions.add(new RegionModel("Region 1"));
            regions.add(new RegionModel("Region 2"));
            regions.add(new RegionModel("Region 3"));
            loadModel();
        }

        return  mData;
    }

    private void loadModel(){
        mData.setValue(regions);
    }

}