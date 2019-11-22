package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class CurtainsModel extends CommonDeviceModel {
    private CurtainsState state;

    public String getStatus() {
        return this.state.getStatus();
    }

    public Integer getLevel() {
        return this.state.getLevel();
    }

    public boolean isOpen() {
        return this.state.isOpen();
    }

    private class CurtainsState {
        private String status;
        private Integer level;

        public String getStatus() {
            return status != null ? status : "";
        }

        public Integer getLevel() {
            return level != null ? level : 0;
        }

        public boolean isOpen() {
            return !this.getStatus().equals("closed");
        }
    }
}
