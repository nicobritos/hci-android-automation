package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;

public class FridgeViewModel extends ViewModel {
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_PARTY = 1;
    public static final int MODE_VACATIONS = 2;
    private static final String TAG = "FridgeViewModel";
    private MutableLiveData<FridgeModel> mFridge;
    private String id;
    // temp
    private FridgeModel model;


    public LiveData<FridgeModel> getModel(String id) {
        if (mFridge == null) {
            mFridge = new MutableLiveData<>();
            this.id = id;
            model = new FridgeModel();
//            model = new FridgeModel("Heladera", id, "ROOM 1");
            loadModel();
        }

        return mFridge;
    }

    private void loadModel() {
        mFridge.setValue(model);
    }

    public void setTemperature(int temperature) {
//        model.temperature = temperature;
        loadModel();
    }


    public void setFreezerTemperature(int temperature) {
//        model.freezerTemperature = temperature;
        loadModel();
    }


    public void setMode(int mode) {
//        model.mode = mode;
        loadModel();
    }

    public Integer getModeInt() {
        switch (this.model.getMode()) {
            case "default":
                return MODE_DEFAULT;
            case "vacation":
                return MODE_PARTY;
            case "party":
                return MODE_VACATIONS;
            default:
                return 0;
        }
    }
}
