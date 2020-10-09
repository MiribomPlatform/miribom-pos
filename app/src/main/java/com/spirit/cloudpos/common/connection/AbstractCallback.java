package com.spirit.cloudpos.common.connection;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * AbstractCallback
 * @author changwoo.son
 */
public abstract class AbstractCallback implements Callback {
    private static final String TAG = AbstractCallback.class.getName();

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        Log.e(TAG, "httpConnection Error - " + e.getMessage(), e);
    }

    @Override
    abstract public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException;
}
