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
            regions.add(new RegionModel("HOLA"));
            regions.add(new RegionModel("ChARU"));
            regions.add(new RegionModel("sdaas"));
            loadModel();
        }

        return  mData;
    }

    private void loadModel(){
        mData.setValue(regions);
    }

}