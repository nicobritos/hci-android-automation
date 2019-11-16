package com.hci.StarkIndustries.data.Models;

import java.util.ArrayList;
import java.util.List;

public class RoutinesListModel {

    protected List<RoutineModel> routines = new ArrayList<>();

    public RoutinesListModel() {
        routines.add(new RoutineModel("Routine 1","Description 1",true));
        routines.add(new RoutineModel("Routine 2","Description 2",false));
        routines.add(new RoutineModel("Routine 3","Description 3",true));
        routines.add(new RoutineModel("Routine 4","Description 4",false));

    }

    public List<RoutineModel> filterDevices(){
        return routines;
    }

    public List<RoutineModel> getRoutines(){
        return filterDevices();
    }
}
