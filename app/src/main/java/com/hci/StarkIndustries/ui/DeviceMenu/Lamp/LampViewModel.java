package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.LampModel;
import com.hci.StarkIndustries.Models.DeviceType;

public class LampViewModel extends ViewModel {

    private static final String TAG = "LampViewModel";
    private MutableLiveData<LampModel> mLamp;
    private String id;

    public LiveData<LampModel> getModel(String id){

        if(mLamp == null){
            Log.d(TAG, "getModel: Loading Model. ID: "+ id);
            this.id = id;
            mLamp = new MutableLiveData<LampModel>();
            loadModel(id);
        }

        return mLamp;
    }

    private void loadModel(String id){
        // Aca habria que hablar con la API
        mLamp.setValue(new LampModel("Lampara",id,"Room1", DeviceType.Lamp));
    }

    public boolean setIntensity(int intensity){
        if (id.isEmpty())
            return false;

        Log.d(TAG, "setIntensity to " + intensity);

        // API
        loadModel(id);
        return true;
    }


    public boolean setColor(int color){
        if (id.isEmpty())
            return false;

        Log.d(TAG, "setColor to 0X" + String.format("%x",color));

        // API
        loadModel(id);
        return true;
    }


    public boolean setEnabled(boolean enabled){
        if (id.isEmpty())
            return false;

        Log.d(TAG, "setEnabled to " + enabled);

        // API
        loadModel(id);
        return true;
    }



}















