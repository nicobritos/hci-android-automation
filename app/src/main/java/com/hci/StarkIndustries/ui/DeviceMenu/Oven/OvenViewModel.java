package com.hci.StarkIndustries.ui.DeviceMenu.Oven;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.OvenModel;

public class OvenViewModel extends ViewModel {

    private MutableLiveData<OvenModel> mOven;
    private String id = "";

    private static final String TAG = "OvenViewModel";

    // TEMp

    private OvenModel model;

    public LiveData<OvenModel> getModel(String Id){

        if(mOven == null){
            mOven = new MutableLiveData<>();
            this.id = Id;
            model =new OvenModel("Horno",id,"ROOM 1");
            loadModel();
        }

        return mOven;
    }

    private void loadModel(){
        mOven.setValue(model);
    }


    void setTemperature(int temperature){
        model.temperature = temperature;
        loadModel();
    }

    public void setPower(boolean isChecked) {
        model.isOn = isChecked;
        loadModel();
    }

    public void setConvectionMode(int position) {
    }

    public void setGrillMode(int position) {
    }

    public void setHeatSource(int position) {
    }

    // Implementar funciones para afectar al modelo


    // TODO: Implement the ViewModel
}
