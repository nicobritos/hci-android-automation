package com.hci.StarkIndustries;

import android.app.Application;
import android.util.Log;

import com.hci.StarkIndustries.data.domain.RoomRepository;

public class MyApplication extends Application {
    private static MyApplication instance;
    private RoomRepository roomRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        roomRepository = RoomRepository.get(this);
        instance = this;
    }

    public synchronized static MyApplication getInstance() {
        return instance;
    }

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }
}
