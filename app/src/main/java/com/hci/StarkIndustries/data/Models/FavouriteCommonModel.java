package com.hci.StarkIndustries.data.Models;

public abstract class FavouriteCommonModel extends CommonModel {
    public boolean isFavourite() {
        Object o = meta.get("favourite");
        if (o instanceof Boolean) return (boolean) o;
        return false;
    }

    public void setFavourite(boolean v) {
        this.meta.put("favourite", v);
    }
}
