package com.anaya.victor.gamea.testviolencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.anaya.victor.gamea.R;

public class ConocePrevieneActivity extends AppCompatActivity {
    LinearLayout linear_info_violencia, linear_caso_violencia, linear_acudir_violencia, linear_comunicate;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conoce_previene);
        init();
    }
    private void init(){
        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("¿Conoce y previene?");
        linear_info_violencia = (LinearLayout)findViewById(R.id.linear_info_violencia);
        linear_caso_violencia = (LinearLayout)findViewById(R.id.linear_caso_violencia);
        linear_acudir_violencia = (LinearLayout)findViewById(R.id.linear_acudir_violencia);
        linear_comunicate = (LinearLayout)findViewById(R.id.linear_comunicate);
        linear_info_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this,InfoViolenciaActivity.class));
            }
        });
        linear_caso_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this, CasoViolenciaActivity.class));
            }
        });
        linear_acudir_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this, DondeAcudirActivity.class));
            }
        });

    }
}
