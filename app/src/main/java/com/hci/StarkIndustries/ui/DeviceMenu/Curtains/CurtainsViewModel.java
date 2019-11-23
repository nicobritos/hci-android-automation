package com.hci.StarkIndustries.ui.DeviceMenu.Curtains;

import android.util.Log;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class CurtainsViewModel extends DeviceViewModel<CurtainsModel> {
    public void setState(boolean state) {
        DeviceRepository.CurtainsActions action;
        if (state) {
            action = DeviceRepository.CurtainsActions.OPEN;
        } else {
            action = DeviceRepository.CurtainsActions.CLOSE;
        }

        Log.d("CURTAINS", "Setting state");
        this.performActionOnDevice(action.getCommand());
    }

    public void toggleState() {
        this.setState(!this.model.isOpen());
    }
}
