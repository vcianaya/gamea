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

public class ArtesanoNoticiaActivity extends AppCompatActivity {
    Button inicio,reg,cur,lupa;
    WebView form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artesano_noticia);

        inicio=(Button)findViewById(R.id.btn_inicio4);
        reg=(Button)findViewById(R.id.btn_registro4);
        cur=(Button)findViewById(R.id.btn_noticia4);
        lupa=(Button)findViewById(R.id.btn_buscar4);

        form=(WebView)findViewById(R.id.wv_form2);
        form.setWebViewClient(new WebViewClient());
        form.loadUrl("http://190.181.41.5/art2/home/noticias");

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent incio=new Intent(ArtesanoNoticiaActivity.this,MainArtesanoActivity.class);
                startActivity(incio);
            }
        });
        cur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent curso=new Intent(ArtesanoNoticiaActivity.this,ArtesanoCursosActivity.class);
                startActivity(curso);
            }
        });
        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro=new Intent(ArtesanoNoticiaActivity.this,ArtesanoBuscarActivity.class);
                startActivity(registro);
            }
        });
    }
}
