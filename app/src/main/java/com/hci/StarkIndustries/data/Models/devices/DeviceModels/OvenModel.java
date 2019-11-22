package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class OvenModel extends CommonDeviceModel {
    public static final String GRILL_LARGE = "large";
    public static final String GRILL_ECO = "eco";
    public static final String GRILL_OFF = "off";

    public static final String HEAT_CONVENTIONAL = "conventional";
    public static final String HEAT_BOTTOM = "bottom";
    public static final String HEAT_TOP = "top";

    public static final String CONVECTION_NORMAL = "normal";
    public static final String CONVECTION_ECO = "eco";
    public static final String CONVECTION_OFF = "off";

    public static final int MIN_TEMPERATURE = 90;
    public static final int MAX_TEMPERATURE = 230;

    private OvenState state;

    public String getStatus() {
        return this.state.getStatus();
    }

    public String getHeat() {
        return this.state.getHeat();
    }

    public String getGrill() {
        return this.state.getGrill();
    }

    public String getConvection() {
        return this.state.getConvection();
    }

    public Integer getTemperature() {
        return this.state.getTemperature();
    }

    public boolean usingConvection() {
        return this.state.usingConvection();
    }

    public boolean usingGrill() {
        return this.state.usingGrill();
    }

    public boolean isPowered() {
        return this.state.isPowered();
    }

    private class OvenState {
        private String status, heat, grill, convection;
        private Integer temperature;

        public String getStatus() {
            return status != null ? status : "";
        }

        public String getHeat() {
            return heat != null ? heat : "";
        }

        public String getGrill() {
            return grill != null ? grill : "";
        }

        public String getConvection() {
            return convection != null ? convection : "";
        }

        public Integer getTemperature() {
            return temperature != null ? temperature : 0;
        }

        public boolean usingConvection() {
            return this.getConvection().equalsIgnoreCase("on");
        }

        public boolean usingGrill() {
            return this.getGrill().equalsIgnoreCase("on");
        }

        public boolean isPowered() {
            return this.getStatus().equalsIgnoreCase("on");
        }
    }
}
