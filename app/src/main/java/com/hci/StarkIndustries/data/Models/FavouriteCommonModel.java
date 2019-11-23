package com.hci.StarkIndustries.data.Models;

import java.util.Observer;

public abstract class FavouriteCommonModel extends CommonModel {

    public String getDescription(){
        Object o = meta.get("description");
        if(o instanceof String)
            return (String) o;
        else
            return "";
    }
    public boolean isFavourite() {
        Object o = meta.get("favourite");
        if (o instanceof Boolean) return (boolean) o;
        return false;
    }
}
