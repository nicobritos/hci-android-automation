package com.hci.StarkIndustries.Models;

import com.hci.StarkIndustries.ui.Miniatures.Routines.RoutinesListViewModel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FavoriteRoutinesListModel extends RoutinesListModel {
    @Override
    public List<RoutineModel> filterDevices() {
        return this.routines.stream().filter(new Predicate<RoutineModel>() {
            @Override
            public boolean test(RoutineModel routineModel) {
                return routineModel.isFavorite;
            }
        }).collect(Collectors.<RoutineModel>toList());
    }
}