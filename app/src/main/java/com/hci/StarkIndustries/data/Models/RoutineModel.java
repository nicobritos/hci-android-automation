package com.hci.StarkIndustries.data.Models;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoutineModel extends FavouriteCommonModel {
    private ArrayList<RoutineAction> actions;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setFavourite(boolean v) {
        this.meta.put("favourite", v);
    }

    @Override
    public JSONObject toJSON() {
        try {
            JSONObject jsonObject;
            jsonObject = super.toJSON();
            jsonObject.put("description", description);

            JSONArray aux = new JSONArray();
            jsonObject.put("actions", aux);

            for (RoutineAction action : actions) {
                aux.put(action.toString());
            }
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }

    private class RoutineAction {
        private List<Map<String, Object>> params;
        private Map<String, Object> meta;
        private CommonDeviceModel device;
        private String actionName;

        @Override
        public String toString() {
            try {
                JSONObject jsonObject = new JSONObject();
                JSONObject deviceJSONObject = new JSONObject();
                deviceJSONObject.put("id", this.device.getId());
                jsonObject.put("device", deviceJSONObject);
                jsonObject.put("actionName", actionName);
                jsonObject.put("params", new JSONArray(params));
                jsonObject.put("meta", new JSONObject(meta));
                return jsonObject.toString();
            } catch (JSONException e) {
                return "{}";
            }
        }
    }
}
