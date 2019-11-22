package com.hci.StarkIndustries;

import android.app.Application;

import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.data.domain.RoomRepository;
import com.hci.StarkIndustries.data.domain.RoutineRepository;

public class MyApplication extends Application {
    private static MyApplication instance;

    public synchronized static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RoomRepository.create(this);
        DeviceRepository.create(this);
        RoutineRepository.create(this);

        instance = this;
    }
}
