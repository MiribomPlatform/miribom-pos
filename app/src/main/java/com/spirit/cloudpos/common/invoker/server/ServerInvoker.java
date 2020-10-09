package com.spirit.cloudpos.common.invoker.server;

import com.spirit.cloudpos.common.interceptor.HttpLoggingInterceptor;
import com.spirit.cloudpos.common.util.GsonUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ServerInvoker {
    // TODO: cache dir 추가 설정
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor())
            .readTimeout(5000, TimeUnit.SECONDS)
            .build();

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private ServerInvoker() {}

    // TODO: invokeGet, invokePut, invokeDelete 생성

    public static void invokePost(ServerCommand serverCommand, Object object, Callback callback) {
        new Thread(() -> {
            HttpUrl url = HttpUrl.parse("http://192.168.123.100:8080" + serverCommand.getCommand());

            String json = GsonUtil.toJsonString(object);

            RequestBody requestBody = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(callback);
        }).start();
    }

}
