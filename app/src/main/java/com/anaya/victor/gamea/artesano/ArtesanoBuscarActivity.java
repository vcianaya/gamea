package com.anaya.victor.gamea.artesano;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.anaya.victor.gamea.R;

public class ArtesanoBuscarActivity extends AppCompatActivity {
    Button inicio,reg,not;
    WebView buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artesano_buscar);
        hideNavigationBar();
        inicio=(Button)findViewById(R.id.btn_inicio3);
        reg=(Button)findViewById(R.id.btn_registro3);
        not=(Button)findViewById(R.id.btn_noticia3);

        buscar=(WebView)findViewById(R.id.wv_form_buscar);
        buscar.setWebViewClient(new WebViewClient());
        buscar.loadUrl("http://190.181.41.5/art2/");


        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(ArtesanoBuscarActivity.this,MainArtesanoActivity.class);
                startActivity(inicio);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro=new Intent(ArtesanoBuscarActivity.this,ArtesanoNoticiaActivity.class);
                startActivity(registro);
            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticia=new Intent(ArtesanoBuscarActivity.this,ArtesanoCursosActivity.class);
                startActivity(noticia);
            }
        });
    }

    private void hideNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
