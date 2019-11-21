package com.hci.StarkIndustries.ui.Miniatures.HouseRegionFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.RegionModel;

public class HouseRegionViewModel extends ViewModel {

    private MutableLiveData<RegionModel> mData;
    private RegionModel model;
    private String id = "";

    LiveData<RegionModel> getModel(String id){

        if(mData == null){
            mData = new MutableLiveData<>();
            model = new RegionModel(id);
            this.id = id;
            loadModel();
        }
        return  mData;
    }

    private void loadModel(){
        mData.setValue(model);
    }
    // TODO: Implement the ViewModel
}
