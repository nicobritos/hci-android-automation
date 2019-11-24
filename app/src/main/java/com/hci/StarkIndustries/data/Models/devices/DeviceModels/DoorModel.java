package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class DoorModel extends CommonDeviceModel {
    private CurtainsState state;

    public String getStatus() {
        return this.state.getStatus();
    }

    public String getLockStatus() {
        return this.state.getLockStatus();
    }

    public boolean isLocked() {
        return this.state.isLocked();
    }

    public boolean isOpen() {
        return this.state.isOpen();
    }

    private class CurtainsState {
        private String status, lock;

        public String getStatus() {
            return status != null ? status : "";
        }

        public String getLockStatus() {
            return lock != null ? lock : "";
        }

        public boolean isLocked() {
            return this.getLockStatus().equalsIgnoreCase("locked");
        }

        public boolean isOpen() {
            return !this.getStatus().equalsIgnoreCase("closed");
        }
    }
}
