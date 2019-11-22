package com.hci.StarkIndustries.ui.home;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoomRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<RoomModel>> mModel;
    private List<RoomModel> model = new ArrayList<>();
    private LifecycleOwner lifecycleOwner;

    public LiveData<List<RoomModel>> getModel(LifecycleOwner lifecycleOwner) {
        if (mModel == null) {
            mModel = new MutableLiveData<>();

            this.lifecycleOwner = lifecycleOwner;
            RoomRepository.get().getRooms().observe(lifecycleOwner, result -> {
                if (result.ok()) {
                    model = result.getResult();
                } else {
                    model = null;
                }
                loadModel();
            });
        }

        return mModel;
    }

    private void loadModel() {
        mModel.setValue(model);
    }
}
