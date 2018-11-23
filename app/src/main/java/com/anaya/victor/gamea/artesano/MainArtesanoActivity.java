package com.anaya.victor.gamea.artesano;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anaya.victor.gamea.R;

public class MainArtesanoActivity extends AppCompatActivity {
    Button reg,noti,lupa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_artesano);
        hideNavigationBar();
        reg=(Button)findViewById(R.id.btn_reg);
        noti=(Button)findViewById(R.id.btn_noticia);
        lupa=(Button)findViewById(R.id.btn_buscar);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainArtesanoActivity.this,ArtesanoNoticiaActivity.class);
                startActivity(intent);
            }
        });
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainArtesanoActivity.this,ArtesanoCursosActivity.class);
                startActivity(intent);
            }
        });
        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainArtesanoActivity.this,ArtesanoBuscarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void hideNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
