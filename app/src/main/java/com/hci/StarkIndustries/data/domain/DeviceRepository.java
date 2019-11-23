package com.hci.StarkIndustries.data.domain;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.remote.Api;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DeviceRepository extends FavouriteRepository {
    private static final String TAG = "DeviceRepository";
    private static DeviceRepository instance;

    private DeviceRepository(Application application) {
        super(application);
    }

    public static synchronized DeviceRepository get() {
        return instance;
    }

    public static synchronized DeviceRepository create(Application application) {
        if (instance == null) {
            instance = new DeviceRepository(application);
        }
        return instance;
    }

    public LiveData<Result<CommonDeviceModel>> getDevice(String id) {
        final MutableLiveData<Result<CommonDeviceModel>> result = new MutableLiveData<>();
        this.api.getDevice(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<Boolean>> performActionOnDevice(String id, String actionId, String key, String value) {
        JSONObject payload = new JSONObject();
        if (key != null) {
            try {
                payload.put(key, value);
            } catch (JSONException e) {
                Log.e(TAG, e.toString());
            }
        }

        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.performActionOnDevice(id, actionId, payload, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices() {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getFavouriteDevices() {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();

        this.api.getDevices(
                getListener(result, commonDeviceModels -> {
                    return commonDeviceModels.stream().filter(CommonDeviceModel::isFavourite).collect(Collectors.toCollection(ArrayList::new));
                }),
                getErrorListener(api, result)
        );

        return result;
    }

    public LiveData<Result<ArrayList<CommonDeviceModel>>> getDevices(String roomId) {
        final MutableLiveData<Result<ArrayList<CommonDeviceModel>>> result = new MutableLiveData<>();
        this.api.getDevices(roomId, getListener(result), getErrorListener(api, result));
        return result;
    }

    @Override
    protected Api.APIEntityType getEntityType() {
        return Api.APIEntityType.DEVICE;
    }

    // Enums
    public enum ACActions {
        TURN_ON("turnOn", null),
        TURN_OFF("turnOff", null),
        SET_MODE("setMode", "mode"),
        SET_FAN_SPEED("setFanSpeed", "fanSpeed"),
        SET_TEMPERATURE("setTemperature", "temperature"),
        SET_VERTICAL_SWING("setVerticalSwing", "verticalSwing"),
        SET_HORIZONTAL_SWING("setHorizontalSwing", "horizontalSwing");

        private String command;
        private String field;

        ACActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum SpeakerActions {
        PLAY("play", null),
        STOP("stop", null),
        PAUSE("pause", null),
        RESUME("resume", null),
        NEXT_SONG("nextSong", null),
        SET_GENRE("setGenre", "genre"),
        SET_VOLUME("setVolume", "volume"),
        GET_PLAYLIST("getPlaylist", null),
        PREVIOUS_SONG("previousSong", null);

        private String command;
        private String field;

        SpeakerActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum CurtainsActions {
        OPEN("open", null),
        CLOSE("close", null);

        private String command;
        private String field;

        CurtainsActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum LampActions {
        TURN_ON("turnOn", null),
        TURN_OFF("turnOff", null),
        SET_COLOR("setColor", "color"),
        SET_BRIGHTNESS("setBrightness", "brightness");

        private String command;
        private String field;

        LampActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum OvenActions {
        TURN_ON("turnOn", null),
        TURN_OFF("turnOff", null),
        SET_HEAT("setHeat", "heat"),
        SET_GRILL("setGrill", "grill"),
        SET_CONVECTION("setConvection", "convection"),
        SET_TEMPERATURE("setTemperature", "temperature");

        private String command;
        private String field;

        OvenActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum FridgeActions {
        SET_TEMPERATURE("setTemperature", "temperature"),
        SET_FREEZER_TEMPERATURE("setFreezerTemperature", "temperature"),
        SET_MODE("setMode", "mode");

        private String command;
        private String field;

        FridgeActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }

    public enum DoorActions {
        OPEN("open", null),
        LOCK("lock", null),
        CLOSE("close", null),
        UNLOCK("unlock", null);

        private String command;
        private String field;

        DoorActions(String command, String field) {
            this.command = command;
            this.field = field;
        }

        public String getCommand() {
            return command;
        }

        public String getField() {
            return field;
        }

        public boolean hasField() {
            return field != null;
        }
    }
}
