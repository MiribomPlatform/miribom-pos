package com.spirit.cloudpos.common.invoker.callback;

import com.orhanobut.logger.Logger;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;

/**
 * AbstractCallback
 * @author changwoo.son
 */
public abstract class AbstractCallback implements Callback {
    private static final String TAG = AbstractCallback.class.getName();

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        Logger.e(TAG, "httpConnection Error - " + e.getMessage(), e);
        e.printStackTrace();
    }
}
