package com.anaya.victor.gamea.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anaya.victor.gamea.R;
import com.anaya.victor.gamea.testviolencia.AcosoSexualActivity;
import com.anaya.victor.gamea.testviolencia.BullyingActivity;
import com.anaya.victor.gamea.testviolencia.RelacionViolentaActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideNavigationBar();
        final Bundle bundle = getIntent().getExtras();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (bundle.get("tipo").toString()) {
                    case "bullying":
                        startActivity(new Intent(SplashActivity.this, BullyingActivity.class));
                        break;
                    case "relacion_violenta":
                        startActivity(new Intent(SplashActivity.this, RelacionViolentaActivity.class));
                        break;
                    case "acoso":
                        startActivity(new Intent(SplashActivity.this, AcosoSexualActivity.class
                        ));
                        break;
                    default:
                        break;
                }
                finish();
            }
        },1000);
    }
    private void hideNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
