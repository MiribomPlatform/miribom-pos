package com.spirit.cloudpos.common.invoker.server;

import com.spirit.cloudpos.common.interceptor.HttpLoggingInterceptor;
import com.spirit.cloudpos.common.util.GsonUtil;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.Headers;
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

    public static final MediaType CONTENT_TYPE_JSON = MediaType.get("application/json; charset=utf-8");

    private ServerInvoker() {}

    // get
    public static void invokeGet(ServerCommand serverCommand, Callback callback) {
        invokeGet(serverCommand, null, callback);
    }

    public static void invokeGet(ServerCommand serverCommand, Map<String, String> queryParams, Callback callback) {
        invokeGet(serverCommand, queryParams, null, callback);
    }

    public static void invokeGet(ServerCommand serverCommand, Map<String, String> queryParams, Map<String, String> headerParams, Callback callback) {
        new Thread(() -> {
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("http://3.131.136.24:8080" + serverCommand.getCommand())).newBuilder();
            if (MapUtils.isNotEmpty(queryParams)) {
                queryParams.forEach(urlBuilder::addQueryParameter);
            }
            HttpUrl url = urlBuilder.build();

            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .get();

            Request request;
            if (MapUtils.isNotEmpty(headerParams)) {
                request = requestBuilder
                        .headers(Headers.of(headerParams))
                        .build();
            } else {
                request = requestBuilder.build();
            }

            client.newCall(request).enqueue(callback);

        }).start();
    }


    // post
    public static void invokePost(ServerCommand serverCommand, Object body, Callback callback) {
        invokePost(serverCommand, null, body, callback);
    }

    public static void invokePost(ServerCommand serverCommand, Map<String, String> queryParams, Object body, Callback callback) {
        invokePost(serverCommand, queryParams, null, body, callback);
    }

    public static void invokePost(ServerCommand serverCommand, Map<String, String> queryParams, Map<String, String> headerParams, Object body, Callback callback) {
        new Thread(() -> {
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("http://3.131.136.24:8080" + serverCommand.getCommand())).newBuilder();
            if (MapUtils.isNotEmpty(queryParams)) {
                queryParams.forEach(urlBuilder::addQueryParameter);
            }
            HttpUrl url = urlBuilder.build();

            String json = GsonUtil.toJsonString(body);

            if (MapUtils.isNotEmpty(headerParams)) {
                Headers headers = Headers.of(headerParams);
            }

            RequestBody requestBody = RequestBody.create(json, CONTENT_TYPE_JSON);

            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .post(requestBody);

            Request request;
            if (MapUtils.isNotEmpty(headerParams)) {
                request = requestBuilder
                        .headers(Headers.of(headerParams))
                        .build();
            } else {
                request = requestBuilder.build();
            }

            client.newCall(request).enqueue(callback);

        }).start();
    }


    // put
    public static void invokePut(ServerCommand serverCommand, Object body, Callback callback) {
        invokePut(serverCommand, null, body, callback);
    }

    public static void invokePut(ServerCommand serverCommand, Map<String, String> queryParams, Object body, Callback callback) {
        invokePut(serverCommand, queryParams, null, body, callback);
    }

    public static void invokePut(ServerCommand serverCommand, Map<String, String> queryParams, Map<String, String> headerParams, Object body, Callback callback) {
        new Thread(() -> {
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("http://3.131.136.24:8080" + serverCommand.getCommand())).newBuilder();
            if (MapUtils.isNotEmpty(queryParams)) {
                queryParams.forEach(urlBuilder::addQueryParameter);
            }
            HttpUrl url = urlBuilder.build();

            String json = GsonUtil.toJsonString(body);

            RequestBody requestBody = RequestBody.create(json, CONTENT_TYPE_JSON);

            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .put(requestBody);

            Request request;
            if (MapUtils.isNotEmpty(headerParams)) {
                request = requestBuilder
                        .headers(Headers.of(headerParams))
                        .build();
            } else {
                request = requestBuilder.build();
            }

            client.newCall(request).enqueue(callback);

        }).start();
    }


    // patch
    public static void invokePatch(ServerCommand serverCommand, Object body, Callback callback) {
        invokePatch(serverCommand, null, body, callback);
    }

    public static void invokePatch(ServerCommand serverCommand, Map<String, String> queryParams, Object body, Callback callback) {
        invokePatch(serverCommand, queryParams, null, body, callback);
    }

    public static void invokePatch(ServerCommand serverCommand, Map<String, String> queryParams, Map<String, String> headerParams, Object body, Callback callback) {
        new Thread(() -> {
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("http://3.131.136.24:8080" + serverCommand.getCommand())).newBuilder();
            if (MapUtils.isNotEmpty(queryParams)) {
                queryParams.forEach(urlBuilder::addQueryParameter);
            }
            HttpUrl url = urlBuilder.build();

            String json = GsonUtil.toJsonString(body);

            RequestBody requestBody = RequestBody.create(json, CONTENT_TYPE_JSON);

            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .patch(requestBody);

            Request request;
            if (MapUtils.isNotEmpty(headerParams)) {
                request = requestBuilder
                        .headers(Headers.of(headerParams))
                        .build();
            } else {
                request = requestBuilder.build();
            }

            client.newCall(request).enqueue(callback);

        }).start();
    }


    // delete
    public static void invokeDelete(ServerCommand serverCommand, Callback callback) {
        invokeDelete(serverCommand, null, callback);
    }

    public static void invokeDelete(ServerCommand serverCommand, Map<String, String> queryParams, Callback callback) {
        invokeDelete(serverCommand, queryParams, null, callback);
    }

    public static void invokeDelete(ServerCommand serverCommand, Map<String, String> queryParams, Map<String, String> headerParams, Callback callback) {
        new Thread(() -> {
            HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("http://3.131.136.24:8080" + serverCommand.getCommand())).newBuilder();
            if (MapUtils.isNotEmpty(queryParams)) {
                queryParams.forEach(urlBuilder::addQueryParameter);
            }
            HttpUrl url = urlBuilder.build();

            Request.Builder requestBuilder = new Request.Builder()
                    .url(url)
                    .delete();

            Request request;
            if (MapUtils.isNotEmpty(headerParams)) {
                request = requestBuilder
                        .headers(Headers.of(headerParams))
                        .build();
            } else {
                request = requestBuilder.build();
            }
            client.newCall(request).enqueue(callback);

        }).start();
    }

}
