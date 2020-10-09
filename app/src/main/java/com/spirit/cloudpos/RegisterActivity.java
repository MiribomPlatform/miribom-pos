package com.spirit.cloudpos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spirit.cloudpos.common.connection.HttpConnection;
import com.spirit.cloudpos.data.RegisterData;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "RegisterActivity";
    EditText regID_ET;
    EditText regName_ET;
    EditText regPN_ET;
    EditText regEmail_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //Buttons
        Button registerBtn = (Button)findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);

        //Text Input Fields
        regID_ET = (EditText)findViewById(R.id.register_userID);
        regName_ET = (EditText)findViewById(R.id.register_userName);
        regPN_ET = (EditText)findViewById(R.id.register_userPN);
        regEmail_ET = (EditText)findViewById(R.id.register_userEmail);






    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.registerBtn:
                //TODO: 여기서 request 서버에 날려주기

                RegisterData registerData = new RegisterData(regID_ET.getText().toString(), regName_ET.getText().toString(), regPN_ET.getText().toString(), regEmail_ET.getText().toString());
                sendData(registerData);


                break;

        }


    }

    private void sendData(final Object object) {
        new Thread() {
            public void run() {
                HttpConnection httpConn = HttpConnection.getInstance();
                httpConn.requestWebServer(object, callback);

            }
        }.start();
    }

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d(TAG, "콜백오류:"+e.getMessage());
        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string();
            Log.d(TAG, "서버에서 응답한 Body:"+body);
        }
    };

}
