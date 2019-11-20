package com.hci.StarkIndustries.ui.Miniatures.FavoriteRoutines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.FavoriteRoutinesListModel;
import com.hci.StarkIndustries.data.Models.RoutinesListModel;
import com.hci.StarkIndustries.ui.Miniatures.Routines.RoutinesListViewModel;

public class FavoriteRoutinesListViewModel extends RoutinesListViewModel {

    @Override
    public LiveData<RoutinesListModel> getModel() {

        if (mRoutine == null) {
            mRoutine = new MutableLiveData<>();
            model = new FavoriteRoutinesListModel();
            loadModel();
        }
        return mRoutine;
    }

}
