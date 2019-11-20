package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;

public class FridgeViewModel extends ViewModel {

    private MutableLiveData<FridgeModel> mFridge;
    private String id;
    private static final String TAG = "FridgeViewModel";

    // temp
    private FridgeModel model;


    public LiveData<FridgeModel> getModel(String id) {

        if (mFridge == null) {
            mFridge = new MutableLiveData<>();
            this.id = id;
            model = new FridgeModel("Heladera", id, "ROOM 1");
            loadModel();
        }

        return mFridge;
    }

    private void loadModel() {
        mFridge.setValue(model);
    }

    public void setTemperature(int temperature) {

        model.temperature = temperature;
        loadModel();
    }


    public void setFreezerTemperature(int temperature) {
        model.freezerTemperature = temperature;
        loadModel();
    }


    public void setMode(int mode) {

        model.mode = mode;
        loadModel();
    }

}
