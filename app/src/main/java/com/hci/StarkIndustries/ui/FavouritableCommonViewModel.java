package com.hci.StarkIndustries.ui;

import androidx.lifecycle.LiveData;

import com.hci.StarkIndustries.data.Models.FavouriteCommonModel;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.domain.FavouriteRepository;

public abstract class FavouritableCommonViewModel<T extends FavouriteCommonModel> extends CommonViewModel<T> {
    public LiveData<Result<Boolean>> setFavourite(boolean value) {
        LiveData<Result<Boolean>> resultLiveData = getRepository().setFavourite(
                model.getId(),
                model.toJSON(),
                value
        );
        resultLiveData.observe(this.lifecycleOwner, this::reloadModelCallback);
        return resultLiveData;
    }

    public LiveData<Result<Boolean>> toggleFavourite() {
        return this.setFavourite(!this.model.isFavourite());
    }

    protected abstract FavouriteRepository getRepository();
}
