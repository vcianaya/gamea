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

public class ArtesanoCursosActivity extends AppCompatActivity {
    Button inicio,reg,cur,lupa;
    WebView form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artesano_cursos);
        hideNavigationBar();
        inicio=(Button)findViewById(R.id.btn_inicio5);
        reg=(Button)findViewById(R.id.btn_registro5);// link noticia
        cur=(Button)findViewById(R.id.btn_noticia5);// link cursos
        lupa=(Button)findViewById(R.id.btn_buscar5);

        form=(WebView)findViewById(R.id.wv_form1);
        form.setWebViewClient(new WebViewClient());
        form.loadUrl("http://190.181.41.5/art2/home/cursos");

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(ArtesanoCursosActivity.this, MainArtesanoActivity.class);
                startActivity(inicio);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro=new Intent(ArtesanoCursosActivity.this, ArtesanoNoticiaActivity.class);
                startActivity(registro);
            }
        });
        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro=new Intent(ArtesanoCursosActivity.this, ArtesanoBuscarActivity.class);
                startActivity(registro);
            }
        });
    }
    private void hideNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
