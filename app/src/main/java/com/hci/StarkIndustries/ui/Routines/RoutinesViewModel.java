package com.hci.StarkIndustries.ui.Routines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.domain.FavouriteRepository;
import com.hci.StarkIndustries.data.domain.RoutineRepository;
import com.hci.StarkIndustries.ui.FavouritableCommonViewModel;

public class RoutinesViewModel extends FavouritableCommonViewModel<RoutineModel> {
    private MutableLiveData<String> mText;

    public RoutinesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    protected FavouriteRepository getRepository() {
        return RoutineRepository.get();
    }

    @Override
    protected void loadModel() {
        RoutineRepository.get().getRoutine(this.id).observe(this.lifecycleOwner, this::onModelLoad);
    }
}