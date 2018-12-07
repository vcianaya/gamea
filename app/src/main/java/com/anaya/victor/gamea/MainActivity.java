package com.anaya.victor.gamea;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anaya.victor.gamea.entities.AccessToken;
import com.anaya.victor.gamea.entities.LoginError;
import com.anaya.victor.gamea.entities.RegisterErr;
import com.anaya.victor.gamea.entities.TokenManager;
import com.anaya.victor.gamea.entities.Utils;
import com.anaya.victor.gamea.network.ApiService;
import com.anaya.victor.gamea.network.RetrofitBuilder;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    TextView register;
    TextInputLayout til_usuario, til_password;
    ApiService service;
    TokenManager tokenManager;
    Call<AccessToken> call;
    AwesomeValidation validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = RetrofitBuilder.createService(ApiService.class);
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        setupRules();
        if (tokenManager.getToken().getAccessToken() != null){
            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            finish();
        }

        initializeItems();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                //startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
    }

    private void setupRules() {
    }



    private void  initializeItems(){
        btn_login = (Button)findViewById(R.id.btn_login);
        til_usuario = (TextInputLayout)findViewById(R.id.til_email);
        til_password = (TextInputLayout)findViewById(R.id.til_password);
        register = (TextView)findViewById(R.id.txt_registrarme);
    }

    private void login(){
        call = service.login(til_usuario.getEditText().getText().toString(),til_password.getEditText().getText().toString());
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()){
                    tokenManager.saveToken(response.body());
                    startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
                    finish();
                }else {
                    if (response.code() == 422 || response.code() == 401){
                        handleErrors(response.errorBody());
                        til_password.getEditText().setText("");
                    }
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });
    }
    private void handleErrors(ResponseBody response){
        LoginError loginError = Utils.loginErrorConver(response);
        if (loginError.getUsername() != null)
            til_usuario.setError(loginError.getUsername().get(0));
        if (loginError.getPassword() !=null)
            til_password.setError(loginError.getPassword().get(0));
        if (loginError.getMessage() != null)
            Toast.makeText(getApplicationContext(), loginError.getMessage(), Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call != null){
            call.cancel();
            call = null;
        }
    }
}
