package com.hci.StarkIndustries.ui.DeviceMenu.Curtains;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class CurtainsViewModel extends DeviceViewModel<CurtainsModel> {
    public void setState(boolean state) {
//        model.isOpen = state;
        loadModel();
    }
}
