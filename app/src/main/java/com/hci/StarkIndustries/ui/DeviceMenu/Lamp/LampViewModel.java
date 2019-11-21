package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.LampModel;

public class LampViewModel extends ViewModel {
    private static final String TAG = "LampViewModel";
    private MutableLiveData<LampModel> mLamp;
    private String id = "";

    // temp
    private LampModel model;

    public LiveData<LampModel> getModel(String id) {

        if (mLamp == null) {
            Log.d(TAG, "getModel: Loading Model. ID: " + id);
            this.id = id;
            mLamp = new MutableLiveData<>();
//            model = new LampModel("Lampara", id, "Room1");
            model = new LampModel();
            loadModel();
        }

        return mLamp;
    }

    private void loadModel() {
        // Aca habria que hablar con la API
        mLamp.setValue(model);
    }

    public boolean setIntensity(int intensity) {


        Log.d(TAG, "setIntensity to " + intensity);

//        model.intensity = intensity;
        // API
        loadModel();
        return true;
    }

    public boolean setColor(int color) {


        Log.d(TAG, "setColor to 0X" + String.format("%x", color));

//        model.color = color;

        // API
        loadModel();
        return true;
    }

    public boolean setEnabled(boolean enabled) {


        Log.d(TAG, "setEnabled to " + enabled);

//        model.isOn = enabled;

        // API
        loadModel();
        return true;
    }
}















