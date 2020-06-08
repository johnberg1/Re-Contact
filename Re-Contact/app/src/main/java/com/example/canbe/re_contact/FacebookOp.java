package com.example.canbe.re_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by RuzgarEserol on 5/11/2017.
 */

public class FacebookOp extends AppCompatActivity {
    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;
    String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_profile_page);
        loginButton = (LoginButton) findViewById(R.id.fb_login_bn);
        textView = (TextView) findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

                @Override
                public void onSuccess (LoginResult loginResult){
                textView.setText("Login success");
                    userId = loginResult.getAccessToken().getUserId();
            }
                @Override
                public void onCancel(){
                textView.setText("Login cancelled");
            }
                @Override
                public void onError (FacebookException error){
                textView.setText("Login error");
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    public String getUserId(){
        return userId;
    }
}