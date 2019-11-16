package com.hci.StarkIndustries.ui.Miniatures.Routines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.RoutinesListModel;

public class RoutinesListViewModel extends ViewModel {

    protected MutableLiveData<RoutinesListModel> mRoutine;
    protected RoutinesListModel model;

    public LiveData<RoutinesListModel> getModel(){

        if(mRoutine == null){
            mRoutine = new MutableLiveData<>();
            model = new RoutinesListModel();
            loadModel();
        }
        return  mRoutine;
    }

    protected void loadModel(){mRoutine.setValue(model);}

}
