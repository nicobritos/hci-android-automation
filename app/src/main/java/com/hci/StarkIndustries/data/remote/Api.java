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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.hci.StarkIndustries.data.Models.RoomModel;

public class Api {
    private final static String TAG = "ar.edu.itba.api";
    private final static String API_ROOMS = "rooms";
    private final static String API_DEVICES = "devices";
    private final static String API_ROUTINES = "routines";
    private final static String API_REGIONS = "homes";

    private static Api instance;
    private static RequestQueue requestQueue;
    // Use IP 10.0.2.2 instead of 127.0.0.1 when running Android emulator in the
    // same computer that runs the API.
    // TODO: Change
    private final String URL = "http://10.0.2.2:9090/api";

    private Api(Context context) {
        requestQueue = VolleySingleton.getInstance(context).getRequestQueue();
    }

    public static synchronized Api getInstance(Context context) {
        if (instance == null) {
            instance = new Api(context);
        }
        return instance;
    }

    // Rooms
    public String getRegions(Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_REGIONS), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRegion(String id, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_REGIONS, id), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    // Rooms
    public String getRooms(Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_ROOMS), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRooms(String sectionId, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_REGIONS, sectionId, API_ROOMS), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRoom(String id, Response.Listener<RoomModel> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, RoomModel> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_ROOMS, id), null, "result", new TypeToken<RoomModel>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);

        return uuid;
    }

    // Devices
    public String getDevices(Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_DEVICES), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getDevices(String roomId, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_ROOMS, roomId, API_DEVICES), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getDevice(String id, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_DEVICES, id), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    // Routines
    public String getRoutines(Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_ROUTINES), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
        String uuid = UUID.randomUUID().toString();
        request.setTag(uuid);
        requestQueue.add(request);
        return uuid;
    }

    public String getRoutine(String id, Response.Listener<ArrayList<RoomModel>> listener, Response.ErrorListener errorListener) {
        GsonRequest<Object, ArrayList<RoomModel>> request =
                new GsonRequest<>(Request.Method.GET, this.formatUrl(API_ROUTINES, id), null, "result", new TypeToken<ArrayList<RoomModel>>(){}, null, listener, errorListener);
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
            } catch (JSONException | UnsupportedEncodingException e) {
            }
        }

        if (!handled) {
            Log.e(TAG, error.toString());

            ArrayList<String> description = new ArrayList<>(Arrays.asList(error.getMessage()));
            response = new Error(6, description);
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
}
