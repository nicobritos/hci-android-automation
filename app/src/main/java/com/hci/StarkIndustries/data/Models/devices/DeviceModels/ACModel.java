package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class ACModel extends CommonDeviceModel {
    private ACState state;

    public boolean isPowered() {
        return this.state.isPowered();
    }

    public int getTemperature() {
        return this.state.getTemperature();
    }

    public String getMode() {
        return this.state.getMode();
    }

    public String getVerticalSwing() {
        return this.state.getVerticalSwing();
    }

    public String getHorizontalSwing() {
        return this.state.getHorizontalSwing();
    }

    public String getFanSpeed() {
        return this.state.getFanSpeed();
    }

    private class ACState {
        private String status;
        private String mode, verticalSwing, horizontalSwing, fanSpeed;
        private Integer temperature;

        public String getStatus() {
            return status != null ? status : "";
        }

        public boolean isPowered() {
            return this.getStatus().equalsIgnoreCase("on");
        }

        public String getMode() {
            return mode != null ? mode : "";
        }

        public String getVerticalSwing() {
            return verticalSwing != null ? verticalSwing : "";
        }

        public String getHorizontalSwing() {
            return horizontalSwing != null ? horizontalSwing : "";
        }

        public String getFanSpeed() {
            return fanSpeed != null ? fanSpeed : "";
        }

        public Integer getTemperature() {
            return temperature != null ? temperature : 0;
        }
    }
}
