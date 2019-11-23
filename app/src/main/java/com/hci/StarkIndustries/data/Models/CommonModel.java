package com.hci.StarkIndustries.data.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public abstract class CommonModel {
    protected Map<String, Object> meta;
    private String name;
    private String id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public JSONObject getMeta() {
        return new JSONObject(meta);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonModel that = (CommonModel) o;
        return getId().equals(that.getId());
    }

    public JSONObject toJSON() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("meta", new JSONObject(meta));
            jsonObject.put("id", id);
            return jsonObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
