package com.hci.StarkIndustries.ui.DeviceMenu.Oven;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.OvenModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class OvenViewModel extends DeviceViewModel<OvenModel> {
    public static final int CONVECTION_OFF = 0;
    public static final int CONVECTION_ECO = 1;
    public static final int CONVECTION_NORMAL = 2;

    public static final int GRILL_OFF = 0;
    public static final int GRILL_ECO = 1;
    public static final int GRILL_LARGE = 2;

    public static final int HEAT_CONVENTIONAL = 0;
    public static final int HEAT_TOP = 1;
    public static final int HEAT_BOTTOM = 2;

    private static final String TAG = "OvenViewModel";

    void setTemperature(int temperature) {
        DeviceRepository.OvenActions action = DeviceRepository.OvenActions.SET_TEMPERATURE;
        this.performActionOnDevice(action.getCommand(), action.getField(), String.valueOf(temperature + OvenModel.MIN_TEMPERATURE));
    }

    public void setPower(boolean isChecked) {
        DeviceRepository.OvenActions action;
        if (isChecked)
            action = DeviceRepository.OvenActions.TURN_ON;
        else
            action = DeviceRepository.OvenActions.TURN_OFF;

        this.performActionOnDevice(action.getCommand());
    }

    public void setConvectionMode(int position) {
        DeviceRepository.OvenActions action = DeviceRepository.OvenActions.SET_CONVECTION;
        String value;

        switch (position) {
            case CONVECTION_NORMAL:
                value = OvenModel.CONVECTION_NORMAL;
                break;
            case CONVECTION_ECO:
                value = OvenModel.CONVECTION_ECO;
                break;
            case CONVECTION_OFF:
                value = OvenModel.CONVECTION_OFF;
                break;
            default:
                return;
        }

        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void setGrillMode(int position) {
        DeviceRepository.OvenActions action = DeviceRepository.OvenActions.SET_GRILL;
        String value;

        switch (position) {
            case GRILL_ECO:
                value = OvenModel.CONVECTION_OFF;
                break;
            case GRILL_LARGE:
                value = OvenModel.GRILL_LARGE;
                break;
            case GRILL_OFF:
                value = OvenModel.GRILL_OFF;
                break;
            default:
                return;
        }

        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void setHeatSource(int position) {
        DeviceRepository.OvenActions action = DeviceRepository.OvenActions.SET_HEAT;
        String value;

        switch (position) {
            case HEAT_BOTTOM:
                value = OvenModel.HEAT_BOTTOM;
                break;
            case HEAT_CONVENTIONAL:
                value = OvenModel.HEAT_CONVENTIONAL;
                break;
            case HEAT_TOP:
                value = OvenModel.HEAT_TOP;
                break;
            default:
                return;
        }

        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public int getConvectionInt() {
        switch (this.model.getConvection()) {
            case OvenModel.CONVECTION_NORMAL:
                return CONVECTION_NORMAL;
            case OvenModel.CONVECTION_ECO:
                return CONVECTION_ECO;
            case OvenModel.CONVECTION_OFF:
                return CONVECTION_OFF;
            default:
                return 0;
        }
    }

    public int getHeatInt() {
        switch (this.model.getHeat()) {
            case OvenModel.HEAT_CONVENTIONAL:
                return HEAT_CONVENTIONAL;
            case OvenModel.HEAT_BOTTOM:
                return HEAT_BOTTOM;
            case OvenModel.HEAT_TOP:
                return HEAT_TOP;
            default:
                return 0;
        }
    }

    public int getGrillInt() {
        switch (this.model.getGrill()) {
            case OvenModel.GRILL_LARGE:
                return GRILL_LARGE;
            case OvenModel.GRILL_ECO:
                return GRILL_ECO;
            case OvenModel.GRILL_OFF:
                return GRILL_OFF;
            default:
                return 0;
        }
    }
}
