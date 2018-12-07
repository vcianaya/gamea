package com.anaya.victor.gamea.testviolencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.anaya.victor.gamea.R;
import com.anaya.victor.gamea.testviolencia.clases.Ubicacion;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class DondeAcudirActivity extends AppCompatActivity {
    ArrayList<Ubicacion>ubicacions;
    RecyclerView recyclerView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donde_acudir);
        init();
    }
    private void init(){
        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lugares donde acudir");
        recyclerView = (RecyclerView)findViewById(R.id.recicler_ubicaciones);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        ubicacions = new ArrayList<Ubicacion>();
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 1","Defensoría De la Niñez y la Adolescencia,\nZona Villa Dolores Inmediaciones de la Iglesia del Rosario, Plena Plaza Obelisco\n69960863 - 2814100", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 1","AIDAJ (Vicente Lema Pizarroso)\nZona Santa Rosa (Lado Colegio Rotary Chuquiago Marka)", new LatLng(-23023.3232,-232323)));



        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 2","Defensoría De la Niñez y la Adolescencia,\nZona Santiago II. En plena Avenida 6 de Marzo entre la Avenida I y la Calle B\69960862 - 2816393", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 2","AIDAJ (Virgen Copacabana)\nZona Horizones II (Centro de Salud integral Virgen de Copacabana)", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 3","Defensoría De la Niñez y la Adolescencia\nZona Pacajes Caluyo, lado Mercado Pacajes. SEGIP y Sub Alcaldía D-3 Cerca Cruce Mayo. Calle F Plaza Pacajes.\n69960861 – 2832083", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 3","Defensoría De la Niñez y la Adolescencia\nZona Villa Adela Yunguyo. Avenida Larecaja entre Calle Cajuata y Calle del Deporte: A una cuadra de la Avenida Bolivia interior Centro de Salud SESO.\n69960860", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 3","Defensoría De la Niñez\ny la Adolescencia (24 HORAS)\nZona San Juan Bautista interior Parroquia San Juan Bautista, lado Plaza de las Banderas a cuatro cuadras antes de llegar a la Radio San Gabriel.\n69960531 – 69960535 – 2860617", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 3","AIDAJ (Villa adela Yungullo)\nVilla adela (urbanizanion Villa Adela Yunguyo)", new LatLng(-23023.3232,-232323)));


        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 4","Defensoría De la Niñez y la Adolescencia\nZona Estrellas de Belén , entre Sub Alcaldía D-4 y CRP Elizardo Pérez, Calle Boyacá frente al Colegio Adventista San José a una cuadra de la Plaza Murillo El Alto.\n69960534 – 2860617", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 4","AIDAJ (Elizardo perez)\nZona 16 de Febrero (CRP Elizardo Perez)\n72546968", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 5","Defensoría De la Niñez y la Adolescencia\nZona puerto de Mejillones Avenida Julián Apaza, lado Sub Alcaldía D-5.\n69960859 - 2805681", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 5","Defensoría De la Niñez y la Adolescencia\nZona Villa Esperanza, interior de la terminal Interprovincial.\n69960050", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 5","AIDAJ (Vicente Donozo Torrez)\nZona Huayna Potosi (CRP Vicente Donozo Torrez)\n72546968", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 6","Defensoría De la Niñez y la Adolescencia\nAvenida Sucre, entre Calle Ingavi y Sucre a una Cuadra de final Castillo lado Colegio “Adrián Castillo  Anexo” altura de la Gasolinera Alto Lima.\n69960858", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 6","Defensoría De la Niñez y la Adolescencia (DNA Interprovincial)\nZona Villa Bolívar “A” Avenida Evadidos del Paraguay. Inmediaciones del Colegio Andrés Bello.\n69960525", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 6","Defensoría De la Niñez y la Adolescencia (DNA Aeropuerto)\nAeropuerto Internacional de El Alto.\n69960854", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 6","AIDAJ (Tupac Amaru)\nZona Alto lima (Tras Cancha Alambrado)\n72546968", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 7","Defensoría De la Niñez y la Adolescencia\nZona San Roque, Carretera Copacabana entre Colegio San Roque y Centro de Salud San Roque, interior Sub Alcaldía D-7 planta baja.\n69960857", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 8","Defensoría De la Niñez y la Adolescencia\nZona Tarapaca “D” Avenida Estela Ponce, interior de la estación policial Integral EPI.\n69960855", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_local_activity_black_24dp,"Distrito 8","AIDAJ (Modelo Boliviano Japones)\nZona senkata (Tras la Sub - Alcaldia)\n72546968", new LatLng(-23023.3232,-232323)));

        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 12","Defensoría De la Niñez y la Adolescencia\nZona Ampliación San pedro de Laja. Avenida San Pedro interior de la Sub Alcaldía Distrito 12.\n69960856", new LatLng(-23023.3232,-232323)));
        ubicacions.add(new Ubicacion( R.drawable.ic_home_black_24dp,"Distrito 14","Defensoría De la Niñez y la Adolescencia\nZona Bautista Saavedra, Carretera Copacabana entre Avenida Bautista Saavedra y José María Acha, lado cancha sintética, interior al centro Tecnológico del mismo nombre.\n69960012", new LatLng(-23023.3232,-232323)));


        AdapterUbicaciones adapterUbicaciones = new AdapterUbicaciones(ubicacions);
        adapterUbicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                startActivity(new Intent(DondeAcudirActivity.this,MapsActivity.class).putExtra("ubicacion",()));
            }
        });
        recyclerView.setAdapter(adapterUbicaciones);
        //Defensoría De la Niñez y la Adolescencia
    }
}
