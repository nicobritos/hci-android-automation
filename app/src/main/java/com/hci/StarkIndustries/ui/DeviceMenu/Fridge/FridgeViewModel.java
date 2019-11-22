package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class FridgeViewModel extends DeviceViewModel<FridgeModel> {
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_PARTY = 1;
    public static final int MODE_VACATION = 2;

    private static final String TAG = "FridgeViewModel";

    public void setTemperature(int temperature) {
        DeviceRepository.FridgeActions action = DeviceRepository.FridgeActions.SET_TEMPERATURE;
        this.performActionOnDevice(action.getCommand(), action.getField(), String.valueOf(temperature + FridgeModel.MIN_TEMPERATURE));
    }

    public void setFreezerTemperature(int temperature) {
        DeviceRepository.FridgeActions action = DeviceRepository.FridgeActions.SET_FREEZER_TEMPERATURE;
        this.performActionOnDevice(action.getCommand(), action.getField(), String.valueOf(temperature + FridgeModel.MIN_FREEZER_TEMPERATURE));
    }

    public void setMode(int mode) {
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_MODE;
        String value;

        switch (mode) {
            case MODE_DEFAULT:
                value = FridgeModel.MODE_DEFAULT;
                break;
            case MODE_PARTY:
                value = FridgeModel.MODE_PARTY;
                break;
            case MODE_VACATION:
                value = FridgeModel.MODE_VACATION;
                break;
            default:
                return;
        }

        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public Integer getModeInt() {
        switch (this.model.getMode()) {
            case FridgeModel.MODE_DEFAULT:
                return MODE_DEFAULT;
            case FridgeModel.MODE_PARTY:
                return MODE_PARTY;
            case FridgeModel.MODE_VACATION:
                return MODE_VACATION;
            default:
                return 0;
        }
    }
}
