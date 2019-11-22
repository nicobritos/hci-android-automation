package com.hci.StarkIndustries.ui.DeviceMenu.Oven;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.OvenModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class OvenViewModel extends DeviceViewModel<OvenModel> {
    public static final int CONVECTION_OFF = 0;
    public static final int CONVECTION_ECO = 1;
    public static final int CONVECTION_DEFAULT = 2;

    public static final int GRILL_OFF = 0;
    public static final int GRILL_ECO = 1;
    public static final int GRILL_LARGE = 2;

    public static final int HEAT_DEFAULT = 0;
    public static final int HEAT_TOP = 1;
    public static final int HEAT_BOTTOM = 2;

    private static final String TAG = "OvenViewModel";

    void setTemperature(int temperature) {
//        model.temperature = temperature;
        loadModel();
    }

    public void setPower(boolean isChecked) {
//        model.isOn = isChecked;
        loadModel();
    }

    public void setConvectionMode(int position) {
    }

    public void setGrillMode(int position) {
    }

    public void setHeatSource(int position) {
    }

    public int getConvectionInt() {
        switch (this.model.getConvection()) {
            case "normal":
                return CONVECTION_DEFAULT;
            case "eco":
                return CONVECTION_ECO;
            case "off":
                return CONVECTION_OFF;
            default:
                return 0;
        }
    }

    public int getHeatInt() {
        switch (this.model.getHeat()) {
            case "conventional":
                return HEAT_DEFAULT;
            case "bottom":
                return HEAT_BOTTOM;
            case "top":
                return HEAT_TOP;
            default:
                return 0;
        }
    }

    public int getGrillInt() {
        switch (this.model.getGrill()) {
            case "large":
                return GRILL_LARGE;
            case "eco":
                return GRILL_ECO;
            case "off":
                return GRILL_OFF;
            default:
                return 0;
        }
    }

    // Implementar funciones para afectar al modelo


    // TODO: Implement the ViewModel
}
