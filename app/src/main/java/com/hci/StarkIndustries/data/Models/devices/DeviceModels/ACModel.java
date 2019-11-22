package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class ACModel extends CommonDeviceModel {
    public static final String MODE_COOL = "cool";
    public static final String MODE_HEAT = "heat";
    public static final String MODE_FAN = "fan";

    public static final String FAN_AUTO = "auto";
    public static final String FAN_25 = "25";
    public static final String FAN_50 = "50";
    public static final String FAN_75 = "75";
    public static final String FAN_100 = "100";

    public static final String HORIZONTAL_SWING_AUTO = "auto";
    public static final String HORIZONTAL_SWING__90 = "25";
    public static final String HORIZONTAL_SWING__45 = "50";
    public static final String HORIZONTAL_SWING_0 = "75";
    public static final String HORIZONTAL_SWING_45= "100";
    public static final String HORIZONTAL_SWING_90= "100";



    public static final int TEMPERATURE_MAX = 38;
    public static final int TEMPERATURE_MIN = 18;

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
        private String status, mode, verticalSwing, horizontalSwing, fanSpeed;
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
