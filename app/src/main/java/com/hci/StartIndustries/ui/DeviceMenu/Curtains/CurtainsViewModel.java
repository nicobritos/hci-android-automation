package com.hci.StartIndustries.ui.DeviceMenu.Curtains;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StartIndustries.Models.DeviceModels.CurtainsModel;
import com.hci.StartIndustries.Models.DeviceType;

public class CurtainsViewModel extends ViewModel {

    private MutableLiveData<CurtainsModel> mCurtains;

    public LiveData<CurtainsModel> getModel(String id){

        if(mCurtains == null){
            mCurtains = new MutableLiveData<CurtainsModel>();
            loadModel(id);
        }

        return mCurtains;
    }

    private void loadModel(String id){
        // Aca habria que hablar con la API
        mCurtains.setValue(new CurtainsModel("Cortinitas",id,"Room1", DeviceType.Curtains));
    }


}
