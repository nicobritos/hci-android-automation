package com.hci.StarkIndustries.ui.DeviceMenu.Curtains;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.Models.DeviceType;

public class CurtainsViewModel extends ViewModel {

    private MutableLiveData<CurtainsModel> mCurtains;
    private CurtainsModel model;
    private String id = "";

    public LiveData<CurtainsModel> getModel(String id){

        if(mCurtains == null){
            mCurtains = new MutableLiveData<CurtainsModel>();
            model = new CurtainsModel("Cortinitas",id,"Room1");
            loadModel();
        }

        return mCurtains;
    }

    private void loadModel(){
        // Aca habria que hablar con la API
        mCurtains.setValue(model);
    }

    public void setState(boolean state){
        model.isOpen = state;
        loadModel();
    }


}
