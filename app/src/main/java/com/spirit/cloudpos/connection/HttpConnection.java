package com.spirit.cloudpos.connection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpConnection {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection();

    public static HttpConnection getInstance() {
        return instance;
    }

    private HttpConnection() {
        this.client = new OkHttpClient();
    }

    public void requestWebServer(Object object, Callback callback) {

        OkHttpClient client = new OkHttpClient();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = new String();
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("http://192.168.43.219:8080/test/user/new")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(callback);
    }

}
