package com.hci.StarkIndustries.data.Models;

import java.util.ArrayList;
import java.util.List;

public class RoutinesListModel {

    protected List<RoutineModel> routines = new ArrayList<>();

    public RoutinesListModel() {

    }

    public List<RoutineModel> filterDevices() {
        return routines;
    }

    public List<RoutineModel> getRoutines() {
        return filterDevices();
    }
}
