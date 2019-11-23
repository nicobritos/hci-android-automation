package com.hci.StarkIndustries.data.Models;

public class RoutineModel extends FavouriteCommonModel {
    private String description;

    public RoutineModel(String name, String description, boolean isFavorite) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
