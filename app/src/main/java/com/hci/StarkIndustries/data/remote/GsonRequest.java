package com.hci.StarkIndustries.data.remote;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class GsonRequest<T1, T2> extends Request<T2> {
    private final Gson gson = new Gson();
    private final T1 data;
    private final String token;
    private final TypeToken<T2> typeToken;
    private final BiFunction<Gson, String, T2> parser;
    private final Map<String, String> headers;
    private final Response.Listener<T2> listener;

    public GsonRequest(int method,
                       String url,
                       T1 data,
                       String token,
                       TypeToken<T2> typeToken,
                       BiFunction<Gson, String, T2> parser,
                       Map<String, String> headers,
                       Response.Listener<T2> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);

        this.data = data;
        this.token = token;
        this.typeToken = typeToken;
        this.parser = parser;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.headers != null ? this.headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T2 response) {
        this.listener.onResponse(response);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return this.data != null ? gson.toJson(this.data).getBytes() : super.getBody();
    }

    @Override
    protected Response<T2> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers)
            );

            if (parser != null) {
                return Response.success(
                        parser.apply(gson, json),
                        HttpHeaderParser.parseCacheHeaders(response));
            } else {
                if (token != null) {
                    JSONObject jsonObject = new JSONObject(json);

                    if (typeToken.getType() == String.class) {
                        json = jsonObject.getString(token);
                    } else if (typeToken.getType() == Boolean.class) {
                        json = (Boolean.valueOf(jsonObject.getBoolean(token))).toString();
                    } else if (typeToken.getType() == Integer.class) {
                        json = (Integer.valueOf(jsonObject.getInt(token))).toString();
                    } else if (typeToken.getType() == Double.class) {
                        json = (Double.valueOf(jsonObject.getDouble(token))).toString();
                    } else if (typeToken.getType() == Long.class) {
                        json = (Long.valueOf(jsonObject.getLong(token))).toString();
                    } else if (Collection.class.isAssignableFrom(typeToken.getRawType())) {
                        json = jsonObject.getJSONArray(token).toString();
                    } else {
                        json = jsonObject.getJSONObject(token).toString();
                    }
                }

                return Response.success(
                        gson.fromJson(json, typeToken.getType()),
                        HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }
}