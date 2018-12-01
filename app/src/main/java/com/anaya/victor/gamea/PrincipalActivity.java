package com.anaya.victor.gamea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.anaya.victor.gamea.artesano.MainArtesanoActivity;
import com.anaya.victor.gamea.denuncia.DenunciaActivity;
import com.anaya.victor.gamea.testviolencia.TestViolenciaActivity;

public class PrincipalActivity extends AppCompatActivity {
    ImageView img_denuncia, img_artesano, img_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        init();

    }
    private void init() {
        img_denuncia = (ImageView)findViewById(R.id.img_denuncia);
        img_artesano = (ImageView)findViewById(R.id.img_artesano);
        img_test = (ImageView)findViewById(R.id.img_test);
        img_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, DenunciaActivity.class));
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
}
