package com.precioslibrosapi.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Libro {
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Precio")
    private Integer precio;
    @JsonProperty("Librería")
    private String libreria;

    public Libro(String link, Integer precio, String libreria) {
        this.link = link;
        this.precio = precio;
        this.libreria = libreria;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getLibreria() {
        return libreria;
    }

    public void setLibreria(String libreria) {
        this.libreria = libreria;
    }
}
