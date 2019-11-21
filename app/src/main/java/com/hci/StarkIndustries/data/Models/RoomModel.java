package com.hci.StarkIndustries.data.Models;

import java.util.Map;

public class RoomModel extends CommonModel {
    private Map<String, String> region;

    public String getRegionId() {
        return this.region != null ? this.region.get("id") : null;
    }

    public String getRegionName() {
        return this.region != null ? this.region.get("name") : null;
    }

    public int getDevicesCount() {
        return this.meta != null ? (int) this.meta.get("count") : 0;
    }
}
