package com.anaya.victor.gamea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.anaya.victor.gamea.artesano.MainArtesanoActivity;
import com.anaya.victor.gamea.denuncia.DenunciaActivity;
import com.anaya.victor.gamea.entities.TokenManager;
import com.anaya.victor.gamea.network.ApiService;
import com.anaya.victor.gamea.network.RetrofitBuilder;
import com.anaya.victor.gamea.testviolencia.TestViolenciaActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalActivity extends AppCompatActivity {
    ImageView img_denuncia, img_artesano, img_test;
    ApiService service;
    TokenManager tokenManager;
    Call<ResponseBody>call;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        init();
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        service = RetrofitBuilder.createServiceWithAuth(ApiService.class,tokenManager);
        if(tokenManager.getToken() == null){
            startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
            finish();
        }

    }
    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img_denuncia = (ImageView)findViewById(R.id.img_denuncia);
        img_artesano = (ImageView)findViewById(R.id.img_artesano);
        img_test = (ImageView)findViewById(R.id.img_test);
        img_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(PrincipalActivity.this, DenunciaActivity.class));
                logout();
            }
        });

        img_artesano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, MainArtesanoActivity.class));
            }
        });

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, TestViolenciaActivity.class));
            }
        });
    }

    private void logout(){
        call = service.logout(tokenManager.getToken().getAccessToken());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    tokenManager.deleteToken();
                    startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(),"Hasta pronto",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.w("ERROR_SERVER",t.getMessage());
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.option_cerrar_session:
                logout();
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call != null){
            call.cancel();
        }
    }
}
