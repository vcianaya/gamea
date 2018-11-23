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

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    TextView register;
    TextInputLayout txt_usuario, txt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideNavigationBar();
        initializeItems();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
    }

    private void hideNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void  initializeItems(){
        btn_login = (Button)findViewById(R.id.btn_login);
        txt_usuario = (TextInputLayout)findViewById(R.id.til_email);
        txt_password = (TextInputLayout)findViewById(R.id.til_password);
        register = (TextView)findViewById(R.id.txt_registrarme);
    }
}
