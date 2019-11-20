package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class FridgeModel extends CommonDeviceModel {
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
