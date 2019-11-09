package com.hci.StarkIndustries.ui.DeviceMenu.AC;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.ACModel;

public class AcViewModel extends ViewModel {

    private MutableLiveData<ACModel> mAC;
    private String id = "";
    private static final String TAG = "AcViewModel";

    public LiveData<ACModel> getModel(String id){
        if(mAC == null)
        {
            this.id = id;
            mAC = new MutableLiveData<>();
            loadModel();
        }
        return mAC;
    }

    private void loadModel(){
        mAC.setValue(new ACModel("AIRE",id,"ROOM 2"));
    }

    // Implementar el resto de las funciones con la API



    // TODO: Implement the ViewModel
}
