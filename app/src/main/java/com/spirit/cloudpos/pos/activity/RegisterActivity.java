package com.spirit.cloudpos.pos.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.spirit.cloudpos.R;
import com.spirit.cloudpos.common.invoker.callback.AbstractCallback;
import com.spirit.cloudpos.common.invoker.server.ServerCommand;
import com.spirit.cloudpos.common.invoker.server.ServerInvoker;
import com.spirit.cloudpos.common.invoker.server.model.TestUser;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    private static final RegisterTestUserCallback registerTestUserCallback = new RegisterTestUserCallback();

    @BindView(R.id.register_userID) EditText regID_ET;
    @BindView(R.id.register_userName) EditText regName_ET;
    @BindView(R.id.register_userPN) EditText regPN_ET;
    @BindView(R.id.register_userEmail) EditText regEmail_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registerBtn)
    public void registerTestUser() {
        TestUser testUser = new TestUser(regID_ET.getText().toString(), regName_ET.getText().toString(), regPN_ET.getText().toString(), regEmail_ET.getText().toString());
        ServerInvoker.invokePost(ServerCommand.TEST_USER_CREATE_URL, testUser, registerTestUserCallback);
    }

    /**
     * TestUser 등록 callback
     */
    private static class RegisterTestUserCallback extends AbstractCallback {
        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            Logger.d(String.format("서버에서 응답한 Body:%s", Objects.requireNonNull(response.body()).string()));
        }
    }

}
