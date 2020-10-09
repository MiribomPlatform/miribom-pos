package com.spirit.cloudpos.common.connection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnection {
    private static HttpConnection instance = new HttpConnection();

    private final OkHttpClient client = new OkHttpClient.Builder().build();



    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");


    public static HttpConnection getInstance() {
        return instance;
    }

    public void requestWebServer(Object object, Callback callback) {

        OkHttpClient client = new OkHttpClient();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                //TODO : url 바꿔야함
                .url("http://localhost:8080/test/user/new")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(callback);
    }

}
