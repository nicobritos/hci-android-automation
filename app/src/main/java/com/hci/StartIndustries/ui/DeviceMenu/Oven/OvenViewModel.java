package com.hci.StartIndustries.ui.DeviceMenu.Oven;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StartIndustries.Models.DeviceModels.OvenModel;

public class OvenViewModel extends ViewModel {

    private MutableLiveData<OvenModel> mOven;
    private String id = "";

    private static final String TAG = "OvenViewModel";

    public LiveData<OvenModel> getModel(String Id){

        if(mOven == null){
            mOven = new MutableLiveData<>();
            this.id = Id;
            loadModel();
        }

        return mOven;
    }

    private void loadModel(){
        mOven.setValue(new OvenModel("Horno",id,"ROOM 1"));
    }

    // Implementar funciones para afectar al modelo


    // TODO: Implement the ViewModel
}
