package com.hci.StarkIndustries.data.Models;

import android.util.Log;

import androidx.annotation.Nullable;

public abstract class CommonModel {
    private String name, meta;
    private final String id;

    CommonModel(String id, String name, String meta) {
        if (id == null) {
            Log.e("com.hci.StarkIndustries.data.Models.CommonModel", "ID is null");
            throw new IllegalArgumentException("ID is null");
        }

        this.id = id;
        this.name = name;
        this.meta = meta;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public void setName(String name) {
        this.name = name;
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
}
