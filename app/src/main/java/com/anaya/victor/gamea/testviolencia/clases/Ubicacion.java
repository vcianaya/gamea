package com.anaya.victor.gamea.testviolencia.clases;

import com.anaya.victor.gamea.R;
import com.google.android.gms.maps.model.LatLng;

public class Ubicacion {
    int icon;
    String distrito, direccion;
    LatLng latLng;

    public Ubicacion(int icon,String distrito, String direccion, LatLng latLng) {
        this.distrito = distrito;
        this.direccion = direccion;
        this.latLng = latLng;
        this.icon = icon;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
