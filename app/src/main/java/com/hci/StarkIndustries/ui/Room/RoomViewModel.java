package com.hci.StarkIndustries.ui.Room;

import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.data.domain.RoomRepository;
import com.hci.StarkIndustries.ui.CommonViewModel;

public class RoomViewModel extends CommonViewModel<RoomModel> {
    @Override
    public void reloadModel() {
        RoomRepository.get().getRoomDevices(this.id).observe(this.lifecycleOwner, this::onModelLoad);
    }
}
