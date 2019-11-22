package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class FridgeViewModel extends DeviceViewModel<FridgeModel> {
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_PARTY = 1;
    public static final int MODE_VACATIONS = 2;

    private static final String TAG = "FridgeViewModel";

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
