package com.anaya.victor.gamea.testviolencia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anaya.victor.gamea.R;
import com.anaya.victor.gamea.testviolencia.clases.Ubicacion;

import java.util.ArrayList;

public class AdapterUbicaciones extends RecyclerView.Adapter<AdapterUbicaciones.ViewHolderUbicaciones> {
    ArrayList<Ubicacion>ubicacions;

    public AdapterUbicaciones(ArrayList<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }

    @NonNull
    @Override
    public ViewHolderUbicaciones onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_lugares,viewGroup,false);
        return new ViewHolderUbicaciones(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUbicaciones viewHolderUbicaciones, int i) {
        viewHolderUbicaciones.asignarDatos(ubicacions.get(i));
    }

    @Override
    public int getItemCount() {
        return ubicacions.size();
    }

    public class ViewHolderUbicaciones extends RecyclerView.ViewHolder {
        TextView txt_ubicacion, txt_distrito, txt_icon;
        public ViewHolderUbicaciones(@NonNull View itemView) {
            super(itemView);
            txt_icon = (TextView)itemView.findViewById(R.id.txt_icon);
            txt_distrito = (TextView)itemView.findViewById(R.id.txt_distrito);
            txt_ubicacion = (TextView)itemView.findViewById(R.id.txt_ubicacion);
        }

        public void asignarDatos(Ubicacion ubicacion) {
            txt_icon.setBackgroundResource(ubicacion.getIcon());
            txt_distrito.setText(ubicacion.getDistrito());
            txt_ubicacion.setText(ubicacion.getDireccion());
        }
    }
}
