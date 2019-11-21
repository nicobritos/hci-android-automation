package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import android.graphics.Color;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class LampModel extends CommonDeviceModel {
    private LampState state;

    public String getStatus() {
        return this.state.getStatus();
    }

    public String getColor() {
        return this.state.getColor();
    }

    public Integer getColorInt() {
        return Color.parseColor(this.state.getColor());
    }

    public Integer getBrightness() {
        return this.state.getBrightness();
    }

    public boolean isPowered() {
        return this.state.isPowered();
    }

    private class LampState {
        private String status, color;
        private Integer brightness;

        public String getStatus() {
            return status != null ? status : "";
        }

        public String getColor() {
            return color != null ? color : "000000";
        }

        public Integer getBrightness() {
            return brightness != null ? brightness : 0;
        }

        public boolean isPowered() {
            return this.getStatus().equalsIgnoreCase("on");
        }
    }
}
