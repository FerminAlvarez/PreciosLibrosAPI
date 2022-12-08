package com.precioslibrosapi.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Libro {
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("link")
    private String link;
    @JsonProperty("precio")
    private Integer precio;
    @JsonProperty("libreria")
    private String libreria;
    @JsonProperty("link_imagen")
    private String imagen;

    public Libro(String titulo, String link, Integer precio, String libreria, String imagen) {
        this.titulo = titulo;
        this.link = link;
        this.precio = precio;
        this.libreria = libreria;
        this.imagen = imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
