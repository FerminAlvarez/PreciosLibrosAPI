package com.precioslibrosapi.Bean;

public class Libro {
    private String link;
    private String precio;
    private String libreria;

    public Libro(String link, String precio, String libreria) {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getLibreria() {
        return libreria;
    }

    public void setLibreria(String libreria) {
        this.libreria = libreria;
    }
}
