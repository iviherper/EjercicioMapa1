package com.example.ejerciciomapa1;

public class Ciudad {
    String nombre;
    Double lat, lng;

    public Ciudad(String nombre, Double lat, Double lng) {
        this.nombre = nombre;
        this.lat = lat;
        this.lng = lng;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
