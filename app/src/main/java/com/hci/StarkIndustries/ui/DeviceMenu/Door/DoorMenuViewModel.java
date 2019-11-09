package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.DoorModel;

public class DoorMenuViewModel extends ViewModel {

    private static final String TAG = "DoorMenuViewModel";
    private MutableLiveData<DoorModel> mModel;
    private String id;

    public LiveData<DoorModel> getModel(String id){

        if(mModel == null){
            mModel = new MutableLiveData<>();
            this.id = id;
            loadModel();
        }

        return mModel;
    }

    private void loadModel(){
        // Usar el ID que esta en la clase
        mModel.setValue(new DoorModel("Puerta",id,"Room1"));

    }

    public boolean open(){
        if(id.isEmpty())
            return false;

        // Do stuff
        loadModel();
        return true;
    }

    public boolean close(){
        if(id.isEmpty())
            return false;

        // Do stuff
        loadModel();
        return true;
    }

    public boolean lock(){
        if(id.isEmpty())
            return false;

        // Do stuff
        loadModel();
        return true;
    }

    public boolean unlock(){
        if(id.isEmpty())
            return false;

        // Do stuff
        loadModel();
        return true;
    }


}
