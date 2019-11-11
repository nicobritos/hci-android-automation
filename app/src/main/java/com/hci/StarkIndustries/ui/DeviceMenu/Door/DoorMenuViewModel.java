package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.DoorModel;

public class DoorMenuViewModel extends ViewModel {

    private static final String TAG = "DoorMenuViewModel";
    private MutableLiveData<DoorModel> mModel;
    private String id = "";
    private DoorModel model;

    public LiveData<DoorModel> getModel(String id){

        if(mModel == null){
            mModel = new MutableLiveData<>();
            this.id = id;
            model =new DoorModel("Puerta",id,"Room1");
            loadModel();
        }

        return mModel;
    }

    private void loadModel(){
        // Usar el ID que esta en la clase
        mModel.setValue(model);

    }

    public boolean open(){


        model.isOpen = true;

        loadModel();
        return true;
    }

    public boolean close(){


        model.isOpen = false;
        // Do stuff
        loadModel();
        return true;
    }

    public boolean lock(){


        model.islocked = true;

        // Do stuff
        loadModel();
        return true;
    }

    public boolean unlock(){


        model.islocked = false;

        // Do stuff
        loadModel();
        return true;
    }


}
