package com.precioslibrosapi.Bean;

public class Libro {
    private String link;
    private Integer precio;
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
