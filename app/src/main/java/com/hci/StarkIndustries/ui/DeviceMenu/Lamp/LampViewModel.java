package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.LampModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class LampViewModel extends DeviceViewModel<LampModel> {
    private static final String TAG = "LampViewModel";

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















