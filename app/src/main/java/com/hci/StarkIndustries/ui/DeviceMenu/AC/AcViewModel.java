package com.hci.StarkIndustries.ui.DeviceMenu.AC;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.DeviceModels.ACModel;

public class AcViewModel extends ViewModel {

    private MutableLiveData<ACModel> mAC;
    private String id = "";
    private static final String TAG = "AcViewModel";
    private ACModel model = null;

    public LiveData<ACModel> getModel(String id){
        if(mAC == null)
        {
            this.id = id;
            mAC = new MutableLiveData<>();
            model = new ACModel("AIRE",id,"ROOM 2");
            loadModel();

        }
        return mAC;
    }

    private void loadModel(){
        mAC.setValue(model);
    }

    public void setPower(boolean isChecked) {
        model.power = isChecked;
        loadModel();
    }

    public void selectVerticalMovement(int position) {
    }

    public void selectHorizontalMovement(int position) {
    }

    public void selectFanSpeed(int position) {
    }

    public void selectMode(int position) {
    }

    public void setTemperature(int i) {
        model.temperature = i;
        loadModel();
    }

    // Implementar el resto de las funciones con la API



    // TODO: Implement the ViewModel
}
