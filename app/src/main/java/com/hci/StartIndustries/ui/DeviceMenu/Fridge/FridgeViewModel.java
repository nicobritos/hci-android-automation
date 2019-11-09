package com.hci.StartIndustries.ui.DeviceMenu.Fridge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StartIndustries.Models.DeviceModels.FridgeModel;

public class FridgeViewModel extends ViewModel {

    private MutableLiveData<FridgeModel> mFridge;
    private String id;
    private static final String TAG = "FridgeViewModel";


    public LiveData<FridgeModel> getModel(String id){

        if(mFridge == null){
            mFridge = new MutableLiveData<>();
            this.id =id;
            loadModel();
        }

        return mFridge;
    }

    private void loadModel(){
        mFridge.setValue(new FridgeModel("Heladera",id,"ROOM 1"));
    }

    public boolean setTemperature(int temperature){
        if(id.isEmpty())
            return false;
        // IMPLEMENTAR

        return true;
    }


    public boolean setFreezerTemperature(int temperature){
        if(id.isEmpty())
            return false;
        // IMPLEMENTAR

        return true;
    }


    public boolean setMode(int mode){
        if(id.isEmpty())
            return false;
        // IMPLEMENTAR

        return true;
    }

}
