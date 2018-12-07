package com.anaya.victor.gamea.testviolencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.anaya.victor.gamea.R;
import com.anaya.victor.gamea.splash.SplashActivity;
import com.anaya.victor.gamea.testviolencia.clases.Preguntas;

import java.util.ArrayList;

public class TestViolenciaActivity extends AppCompatActivity {
    ImageView img_bullying, img_relacion_violenta, img_acoso, img_conoce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_violencia);
        /*
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        */
        init();
    }
    private void init() {
        img_bullying = (ImageView)findViewById(R.id.img_bullying);
        img_bullying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo","bullying");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });

        img_relacion_violenta = (ImageView)findViewById(R.id.img_relacion_violenta);
        img_relacion_violenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo","relacion_violenta");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });

        img_acoso = (ImageView)findViewById(R.id.img_acoso);
        img_acoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo","acoso");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });
        img_conoce = (ImageView)findViewById(R.id.img_conoce);
        img_conoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestViolenciaActivity.this, ConocePrevieneActivity.class));
            }
        });
    }
}
