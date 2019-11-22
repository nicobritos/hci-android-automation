package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.LampModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

import static com.hci.StarkIndustries.ui.DeviceMenu.Fridge.FridgeViewModel.MODE_PARTY;
import static com.hci.StarkIndustries.ui.DeviceMenu.Fridge.FridgeViewModel.MODE_VACATION;

public class LampViewModel extends DeviceViewModel<LampModel> {
    private static final String TAG = "LampViewModel";

    public void setIntensity(int intensity) {
        DeviceRepository.LampActions action = DeviceRepository.LampActions.SET_BRIGHTNESS;
        this.performActionOnDevice(action.getCommand(), action.getField(), String.valueOf(intensity));
    }

    public void setColor(int color) {
        DeviceRepository.LampActions action = DeviceRepository.LampActions.SET_COLOR;
        this.performActionOnDevice(action.getCommand(), action.getField(), colorToString(color));
    }

    public void setEnabled(boolean enabled) {
        DeviceRepository.LampActions action;

        if (enabled)
            action = DeviceRepository.LampActions.TURN_ON;
        else
            action = DeviceRepository.LampActions.TURN_OFF;

        this.performActionOnDevice(action.getCommand());
    }

    private String colorToString(int color) {
        StringBuilder stringBuilder = new StringBuilder();

        // Red
        stringBuilder.append(Integer.toHexString((color & 0xff0000) >>> (8 * 2)));
        // Blue
        stringBuilder.append(Integer.toHexString((color & 0xff00) >>> 8));
        // Green
        stringBuilder.append(Integer.toHexString(color & 0xff));

        return stringBuilder.toString();
    }
}
