package com.hci.StarkIndustries.data.domain;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.remote.Api;

import java.util.function.Function;

public abstract class CommonRepository {
    protected final Api api;

    protected CommonRepository(Application application) {
        this.api = Api.getInstance(application);
    }

    protected static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result) {
        return (response) -> {
            result.setValue(new Result<>(response));
        };
    }

    protected static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result, final Function<T, T> filtered) {
        return (response) -> result.setValue(new Result<>(filtered.apply(response)));
    }

    protected static <T> Response.ErrorListener getErrorListener(final Api api, final MutableLiveData<Result<T>> result) {
        return (error) -> result.setValue(new Result<>(null, api.handleError(error)));
    }
}
