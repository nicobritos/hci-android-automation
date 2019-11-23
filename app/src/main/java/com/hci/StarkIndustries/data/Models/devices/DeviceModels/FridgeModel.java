package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class FridgeModel extends CommonDeviceModel {
    public static final int MIN_FREEZER_TEMPERATURE = -20;
    public static final int MAX_FREEZER_TEMPERATURE = -8;
    public static final int MIN_TEMPERATURE = 2;
    public static final int MAX_TEMPERATURE = 8;

    public static final String MODE_VACATION = "vacation";
    public static final String MODE_DEFAULT = "default";
    public static final String MODE_PARTY = "party";

    private FridgeState state;

    public String getMode() {
        return this.state.getMode();
    }

    public Integer getTemperature() {
        return this.state.getTemperature();
    }

    public Integer getFreezerTemperature() {
        return this.state.getFreezerTemperature();
    }

    private class FridgeState {
        private String mode;
        private Integer temperature, freezerTemperature;

        public String getMode() {
            return mode != null ? mode : "";
        }

        public Integer getTemperature() {
            return temperature != null ? temperature : 0;
        }

        public Integer getFreezerTemperature() {
            return freezerTemperature != null ? freezerTemperature : 0;
        }
    }
}
