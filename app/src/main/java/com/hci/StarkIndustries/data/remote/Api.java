package com.hci.StarkIndustries.data.remote;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.ACModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.DoorModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.LampModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.OvenModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceTypeEnum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Api {
    private final static String TAG = "ar.edu.itba.api";
    private final static String API_ROOMS = "rooms";
    private final static String API_DEVICES = "devices";
    private final static String API_ROUTINES = "routines";
    private final static String API_REGIONS = "homes";
    private final static String API_ROUTINES_EXECUTE = "execute";

    private static Api instance;
    private static RequestQueue requestQueue;
    // Use IP 10.0.2.2 instead of 127.0.0.1 when running Android emulator in the
    // same computer that runs the API.
    // TODO: Change

    private static String URL = "http://10.0.2.2:9090/api";

    public static void setEndpoint(String newEndpoint){
        URL = newEndpoint;
    }


    private Api(Context context) {
        requestQueue = VolleySingleton.getInstance(context).getRequestQueue();
    }

    public static synchronized Api getInstance(Context context) {
        if (instance == null) {
            instance = new Api(context);
        }
        return instance;
    }

    // Regions
    public String getRegions(Response.Listener<ArrayList<RegionModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RegionModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_REGIONS),
                null,
                "result",
                new TypeToken<ArrayList<RegionModel>>() {
                },
                null,
                null,
                response -> {
                    Result<ArrayList<RegionModel>> regionResult = new Result<>(response);

                    ArrayList<RegionModel> out = new ArrayList<>();
                    for (RegionModel regionModel : regionResult.getResult()) {
                        getRooms(regionModel.getId(),
                                roomsResponse -> {
                                    Result<ArrayList<RoomModel>> roomsResult = new Result<>(roomsResponse);
                                    regionModel.addRooms(roomsResult.getResult());
                                    out.add(regionModel);
                                    if (out.size() == regionResult.getResult().size()) {
                                        listener.onResponse(out);
                                    }
                                },
                                error -> {
                                    out.add(regionModel);
                                    errorListener.onErrorResponse(error);
                                }
                        );
                    }
                },
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRegion(String id, Response.Listener<RegionModel> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, RegionModel> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_REGIONS, id),
                null,
                "result",
                new TypeToken<RegionModel>() {
                },
                null,
                null,
                response -> {
                    Result<RegionModel> regionResult = new Result<>(response);
                    getRooms(id,
                            roomsResponse -> {
                                Result<ArrayList<RoomModel>> roomsResult = new Result<>(roomsResponse);
                                regionResult.getResult().addRooms(roomsResult.getResult());
                                listener.onResponse(regionResult.getResult());
                            },
                            errorListener
                    );
                },
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    // Rooms
    public String getRooms(Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROOMS),
                null,
                "result",
                new TypeToken<ArrayList<RoomModel>>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRooms(String sectionId, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_REGIONS, sectionId, API_ROOMS),
                null,
                "result",
                new TypeToken<ArrayList<RoomModel>>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRoom(String id, Response.Listener<RoomModel> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, RoomModel> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROOMS, id),
                null,
                "result",
                new TypeToken<RoomModel>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);

        return uuid;
    }

    public String getRoomDevices(String id, Response.Listener<RoomModel> listener, Response.ErrorListener errorListener) {
        return this.getRoom(
                id,
                roomResponse -> {
                    this.getDevices(
                            id,
                            devicesResponse -> {
                                roomResponse.addDevices(devicesResponse);
                                listener.onResponse(roomResponse);
                            },
                            errorListener
                    );
                },
                errorListener
        );
    }

    // Devices
    public String getDevices(Response.Listener<ArrayList<CommonDeviceModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<CommonDeviceModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_DEVICES),
                null,
                "result",
                null,
                this::parseDevices,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getDevices(String roomId, Response.Listener<ArrayList<CommonDeviceModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<CommonDeviceModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROOMS, roomId, API_DEVICES),
                null,
                "result",
                null,
                this::parseDevices,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getDevice(String id, Response.Listener<CommonDeviceModel> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, CommonDeviceModel> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_DEVICES, id),
                null,
                "result",
                null,
                this::parseDevice,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String performActionOnDevice(String id, String actionId, JSONArray payload, Response.Listener<Object> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, Object> request = new GsonRequest<>(
                Request.Method.PUT,
                this.formatUrl(API_DEVICES, id, actionId),
                payload,
                "result",
                new TypeToken<Object>() {
                },
                this::parseDeviceAction,
                this.getHeaders(),
                listener,
                errorListener
        );



        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    // Routines
    public String getRoutines(Response.Listener<ArrayList<RoutineModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoutineModel>> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROUTINES),
                null,
                "result",
                new TypeToken<ArrayList<RoutineModel>>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRoutine(String id, Response.Listener<RoutineModel> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, RoutineModel> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROUTINES, id),
                null,
                "result",
                new TypeToken<RoutineModel>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String executeRoutine(String id, Response.Listener<Boolean> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, Boolean> request = new GsonRequest<>(
                Request.Method.GET,
                this.formatUrl(API_ROUTINES, id, API_ROUTINES_EXECUTE),
                null,
                "result",
                new TypeToken<Boolean>() {
                },
                null,
                null,
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    // General
    public String updateMeta(String id, JSONObject parsedObject, APIEntityType entityType, Response.Listener<Boolean> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, Boolean> request = new GsonRequest<>(
                Request.Method.PUT,
                this.formatUrl(getEndpoint(entityType), id),
                parsedObject,
                "result",
                new TypeToken<Boolean>() {
                },
                null,
                this.getHeaders(),
                listener,
                errorListener
        );

        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public void cancelRequest(String uuid) {
        if ((uuid != null) && (requestQueue != null)) {
            requestQueue.cancelAll(uuid);
        }
    }

    public Error handleError(VolleyError error) {
        Error response = null;
        boolean handled = false;

        NetworkResponse networkResponse = error.networkResponse;
        if ((networkResponse != null) && (error.networkResponse.data != null)) {
            try {
                String json = new String(
                        error.networkResponse.data,
                        HttpHeaderParser.parseCharset(networkResponse.headers));

                JSONObject jsonObject = new JSONObject(json);
                json = jsonObject.getJSONObject("error").toString();

                Gson gson = new Gson();
                response = gson.fromJson(json, Error.class);
                handled = true;
            } catch ( Exception   e) {
                Log.d(TAG, "handleError: %s",e.getCause());
            }
        }

        if (!handled) {
            Log.e(TAG, error.toString());

            response = new Error(6, error.getMessage());
        }

        return response;
    }

    private String formatUrl(String... paths) {
        if (paths == null || paths.length == 0)
            return URL;
        StringBuilder url = new StringBuilder();
        url.append(URL);
        for (String path : paths) {
            url.append('/');
            url.append(path);
        }

        return url.toString();
    }

    private ArrayList<CommonDeviceModel> parseDevices(Gson gson, String jsonString) {
        ArrayList<CommonDeviceModel> list = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray array;
            if (jsonObject.has("devices")) {
                array = new JSONObject(jsonString).getJSONArray("devices");
            } else {
                array = new JSONObject(jsonString).getJSONArray("result");
            }

            for (int i = 0; i < array.length(); i++) {
                list.add(this.parseDeviceJSON(gson, array.getJSONObject(i)));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private CommonDeviceModel parseDevice(Gson gson, String jsonString) {
        try {
            return this.parseDeviceJSON(gson, new JSONObject(jsonString).getJSONObject("result"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private Object parseDeviceAction(Gson gson, String jsonString) {
        return true;
    }

    private CommonDeviceModel parseDeviceJSON(Gson gson, JSONObject jsonObject) {
        try {
            switch (DeviceTypeEnum.getDeviceTypeEnumFromId(jsonObject.getJSONObject("type").getString("id"))) {
                case Door:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<DoorModel>() {
                    }).getType());
                case Speaker:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<SpeakerModel>() {
                    }).getType());
                case AC:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<ACModel>() {
                    }).getType());
                case Curtains:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<CurtainsModel>() {
                    }).getType());
                case Fridge:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<FridgeModel>() {
                    }).getType());
                case Lamp:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<LampModel>() {
                    }).getType());
                case Oven:
                    return gson.fromJson(jsonObject.toString(), (new TypeToken<OvenModel>() {
                    }).getType());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private String getEndpoint(APIEntityType entityType) {
        switch (entityType) {
            case ROOM:
                return API_ROOMS;
            case DEVICE:
                return API_DEVICES;
            case REGION:
                return API_REGIONS;
            case ROUTINE:
                return API_ROUTINES;
            default:
                return null;
        }
    }

    public Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }


    public enum APIEntityType {
        DEVICE, ROOM, REGION, ROUTINE
    }
    
    static public String getEventsUrl() {
        StringBuilder url = new StringBuilder();
        url.append(URL);
        url.append('/');
        url.append("devices");
        url.append('/');
        url.append("events");

        return url.toString();
    }

    public static String getDeviceUrl( String id) {
        StringBuilder url = new StringBuilder();
        url.append(URL);
        url.append('/');
        url.append("devices");
        url.append('/');
        url.append(id);

        return url.toString();
    }
}
