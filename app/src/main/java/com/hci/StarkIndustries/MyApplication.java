package com.hci.StarkIndustries;

import android.app.Application;

import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoomRepository;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        RoomRepository.create(this);
        DeviceRepository.create(this);

        instance = this;
    }

    public synchronized static MyApplication getInstance() {
        return instance;
    }
}
