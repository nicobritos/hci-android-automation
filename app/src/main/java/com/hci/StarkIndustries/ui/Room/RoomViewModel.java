package com.hci.StarkIndustries.ui.Room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.RoomModel;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.DevicesRecyclerViewClickInteface;

public class RoomViewModel extends ViewModel {

    private MutableLiveData<RoomModel> mData;
    private RoomModel model;


    public LiveData<RoomModel> getModel(String id){

        if(mData == null){
            mData = new MutableLiveData<>();
            model = new RoomModel(id);
            loadModel();
        }


        return  mData;
    }

    private void loadModel(){
        mData.setValue(model);
    }
}
