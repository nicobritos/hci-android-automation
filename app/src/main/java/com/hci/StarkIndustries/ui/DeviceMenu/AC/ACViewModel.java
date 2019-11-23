package com.hci.StarkIndustries.ui.DeviceMenu.AC;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.ACModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
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

    public static final int MODE_COOL = 0;
    public static final int MODE_HEAT = 1;
    public static final int MODE_FAN = 2;

    private static final String TAG = "ACViewModel";

    public void setPower(boolean isChecked) {
        if (isChecked == this.model.isPowered()) return;

        DeviceRepository.ACActions action;
        if (isChecked)
            action = DeviceRepository.ACActions.TURN_ON;
        else
            action = DeviceRepository.ACActions.TURN_OFF;

        this.performActionOnDevice(action.getCommand());
    }

    public void selectVerticalMovement(int position) {
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_VERTICAL_SWING;
        String value;

        switch (position) {
            case VERTICAL_SWING_AUTO:
                value = ACModel.VERTICAL_SWING_AUTO;
                break;
            case VERTICAL_SWING_22:
                value = ACModel.VERTICAL_SWING_22;
                break;
            case VERTICAL_SWING_45:
                value = ACModel.VERTICAL_SWING_45;
                break;
            case VERTICAL_SWING_67:
                value = ACModel.VERTICAL_SWING_67;
                break;
            case VERTICAL_SWING_90:
                value = ACModel.VERTICAL_SWING_90;
                break;
            default:
                return;
        }

        if (value.equals(this.model.getVerticalSwing())) return;
        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void selectHorizontalMovement(int position) {
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_HORIZONTAL_SWING;
        String value;

        switch (position) {
            case HORIZONTAL_SWING_AUTO:
                value = ACModel.HORIZONTAL_SWING_AUTO;
                break;
            case HORIZONTAL_SWING__90:
                value = ACModel.HORIZONTAL_SWING__90;
                break;
            case HORIZONTAL_SWING__45:
                value = ACModel.HORIZONTAL_SWING__45;
                break;
            case HORIZONTAL_SWING_0:
                value = ACModel.HORIZONTAL_SWING_0;
                break;
            case HORIZONTAL_SWING_45:
                value = ACModel.HORIZONTAL_SWING_45;
                break;
            case HORIZONTAL_SWING_90:
                value = ACModel.HORIZONTAL_SWING_90;
                break;
            default:
                return;
        }

        if (value.equals(this.model.getHorizontalSwing())) return;
        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void selectFanSpeed(int position) {
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_FAN_SPEED;
        String value;

        switch (position) {
            case FAN_AUTO:
                value = ACModel.FAN_AUTO;
                break;
            case FAN_25:
                value = ACModel.FAN_25;
                break;
            case FAN_50:
                value = ACModel.FAN_50;
                break;
            case FAN_75:
                value = ACModel.FAN_75;
                break;
            case FAN_100:
                value = ACModel.FAN_100;
                break;
            default:
                return;
        }

        if (value.equals(this.model.getFanSpeed())) return;
        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void selectMode(int position) {
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_MODE;
        String value;

        switch (position) {
            case MODE_COOL:
                value = ACModel.MODE_COOL;
                break;
            case MODE_FAN:
                value = ACModel.MODE_FAN;
                break;
            case MODE_HEAT:
                value = ACModel.MODE_HEAT;
                break;
            default:
                return;
        }

        if (value.equals(this.model.getMode())) return;
        this.performActionOnDevice(action.getCommand(), action.getField(), value);
    }

    public void setTemperature(int temperature) {
        if (temperature == this.model.getTemperature()) return;
        DeviceRepository.ACActions action = DeviceRepository.ACActions.SET_TEMPERATURE;

        this.performActionOnDevice(action.getCommand(), action.getField(), temperature);
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
            case ACModel.HORIZONTAL_SWING_AUTO:
                return HORIZONTAL_SWING_AUTO;
            case ACModel.HORIZONTAL_SWING__90:
                return HORIZONTAL_SWING__90;
            case ACModel.HORIZONTAL_SWING__45:
                return HORIZONTAL_SWING__45;
            case ACModel.HORIZONTAL_SWING_0:
                return HORIZONTAL_SWING_0;
            case ACModel.HORIZONTAL_SWING_45:
                return HORIZONTAL_SWING_45;
            case ACModel.HORIZONTAL_SWING_90:
                return HORIZONTAL_SWING_90;
            default:
                return 0;
        }
    }

    public Integer getVerticalSwingInt() {
        switch (this.model.getVerticalSwing()) {
            case ACModel.VERTICAL_SWING_AUTO:
                return VERTICAL_SWING_AUTO;
            case ACModel.VERTICAL_SWING_22:
                return VERTICAL_SWING_22;
            case ACModel.VERTICAL_SWING_45:
                return VERTICAL_SWING_45;
            case ACModel.VERTICAL_SWING_67:
                return VERTICAL_SWING_67;
            case ACModel.VERTICAL_SWING_90:
                return VERTICAL_SWING_90;
            default:
                return 0;
        }
    }
}
