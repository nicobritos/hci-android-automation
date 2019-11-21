package com.hci.StarkIndustries.data.Models;

public class RoutineModel extends CommonModel {

    public String Name;
    public String Description;
    public boolean isFavorite;

    public RoutineModel(String name, String description, boolean isFavorite) {
        Name = name;
        Description = description;
        this.isFavorite = isFavorite;
    }
}
