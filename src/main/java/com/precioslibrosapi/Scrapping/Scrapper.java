package com.precioslibrosapi.Scrapping;

import com.precioslibrosapi.Bean.Libro;

public interface Scrapper {
    void establecerISBN(String ISBN);

    String obtenerNombreTienda();

    Libro obtenerLibro();

    void scrappearLibro();
}
