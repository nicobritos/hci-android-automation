package com.hci.StarkIndustries.data.Models;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.remote.Api;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationWorker extends Worker {

    StringBuilder received_res = new StringBuilder();
    String url = Api.getEventsUrl();


    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    public void getCurrEvents() {
        received_res.append("start");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = Api.getEventsUrl();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Matcher m = Pattern.compile("(?m)^.*deviceId.*$").matcher(response);
                        Log.e("worker-match",response);
                        while (m.find()) {
                            Log.e("worker-match",m.group());
                            String deviceUrl = Api.getDeviceUrl(m.group().substring(20,36));
                            Log.e("worker-match",deviceUrl);
                            StringRequest deviceRequest = new StringRequest(Request.Method.GET, deviceUrl, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.e("worker-match",response);
                                    String temp = response.substring(response.indexOf("name") + 8 );
                                    Log.e("worker-match",temp);
                                    Log.e("worker-match",temp.substring(0,temp.indexOf('"')));
                                    open_notification(temp.substring(0,temp.indexOf('"')));
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {}});
                            queue.add(deviceRequest);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("worker-url","error");
            }
        });

        queue.add(stringRequest);
    }

    @NonNull
    @Override
    public Result doWork() {
        getCurrEvents();


        return Result.success();
    }

    @TargetApi(26)
    private void open_notification(String device_name) {


        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "stark";
        int importance = NotificationManager.IMPORTANCE_LOW;


        NotificationChannel notificationChannel = new NotificationChannel(channelId, "StarkIndustries", importance);

        notificationManager.createNotificationChannel(notificationChannel);

        StringBuilder desc = new StringBuilder().append("State of ").append(device_name).append(" has been modified recently.");
        Notification notification = new Notification.Builder(getApplicationContext(), channelId)
                .setContentTitle("A device has been recently modified.")
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true).build();

        notificationManager.notify(0, notification);
    }
}
