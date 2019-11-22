package com.hci.StarkIndustries.ui.DeviceMenu.AC;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.ACModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class ACViewModel extends DeviceViewModel<ACModel> {
    public static final int FAN_AUTO = 0;
    public static final int FAN_25 = 1;
    public static final int FAN_50 = 2;
    public static final int FAN_75 = 3;
    public static final int FAN_100 = 4;

    public static final int HORIZONTAL_SWING_AUTO = 0;
    public static final int HORIZONTAL_SWING__90 = 1;
    public static final int HORIZONTAL_SWING__45 = 2;
    public static final int HORIZONTAL_SWING_0 = 3;
    public static final int HORIZONTAL_SWING_45 = 4;
    public static final int HORIZONTAL_SWING_90 = 5;

    public static final int VERTICAL_SWING_AUTO = 0;
    public static final int VERTICAL_SWING_22 = 1;
    public static final int VERTICAL_SWING_45 = 2;
    public static final int VERTICAL_SWING_67 = 3;
    public static final int VERTICAL_SWING_90 = 4;

    public static final int MODE_COOL = 1;
    public static final int MODE_HEAT = 2;
    public static final int MODE_FAN = 3;

    private static final String TAG = "ACViewModel";

    public void setPower(boolean isChecked) {
//        model.power = isChecked;
        loadModel();
    }

    public void selectVerticalMovement(int position) {
    }

    public void selectHorizontalMovement(int position) {
    }

    public void selectFanSpeed(int position) {
    }

    public void selectMode(int position) {
    }

    public void setTemperature(int i) {
//        model.temperature = i;
        loadModel();
    }

    public Integer getModeInt() {
        switch (this.model.getMode()) {
            case ACModel.MODE_COOL:
                return MODE_COOL;
            case ACModel.MODE_HEAT:
                return MODE_HEAT;
            case ACModel.MODE_FAN:
                return MODE_FAN;
            default:
                return 0;
        }
    }

    public Integer getFanSpeedInt() {
        switch (this.model.getFanSpeed()) {
            case ACModel.FAN_AUTO:
                return FAN_AUTO;
            case ACModel.FAN_25:
                return FAN_25;
            case ACModel.FAN_50:
                return FAN_50;
            case ACModel.FAN_75:
                return FAN_75;
            case ACModel.FAN_100:
                return FAN_100;
            default:
                return 0;
        }
    }

    public Integer getHorizontalSwingInt() {
        switch (this.model.getHorizontalSwing()) {
            case "auto":
                return HORIZONTAL_SWING_AUTO;
            case "-90":
                return HORIZONTAL_SWING__90;
            case "-45":
                return HORIZONTAL_SWING__45;
            case "0":
                return HORIZONTAL_SWING_0;
            case "45":
                return HORIZONTAL_SWING_45;
            case "90":
                return HORIZONTAL_SWING_90;
            default:
                return 0;
        }
    }

    public Integer getVerticalSwingInt() {
        switch (this.model.getVerticalSwing()) {
            case "auto":
                return VERTICAL_SWING_AUTO;
            case "22":
                return VERTICAL_SWING_22;
            case "45":
                return VERTICAL_SWING_45;
            case "67":
                return VERTICAL_SWING_67;
            case "90":
                return VERTICAL_SWING_90;
            default:
                return 0;
        }
    }

    // Implementar el resto de las funciones con la API


    // TODO: Implement the ViewModel
}
