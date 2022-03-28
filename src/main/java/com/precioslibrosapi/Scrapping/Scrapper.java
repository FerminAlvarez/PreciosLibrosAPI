package com.precioslibrosapi.Scrapping;

import com.precioslibrosapi.Bean.Libro;

public interface Scrapper extends Runnable {
    void establecerISBN(String ISBN);

    String obtenerNombreTienda();

    Libro obtenerLibro();
}
