package com.precioslibrosapi.Scrapping.Implementations;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import com.precioslibrosapi.Scrapping.ScrappingUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class BuscaLibreScrapper implements Scrapper {

    private final String nombreTienda = "BuscaLibre";
    private String ISBN = null;
    private Libro libro = null;

    @Override
    public void establecerISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String obtenerNombreTienda() {
        return nombreTienda;
    }

    public Libro obtenerLibro() {
        return libro;
    }

    public void scrappearLibro() {
        try {
            Document conexion = Jsoup.connect("https://www.buscalibre.com.ar/libros/search?q=" + ISBN).get();
            Element portada = conexion.getElementsByClass("info-libro").first();

            String precio = portada.getElementsByClass("precioAhora").first().text();
            String linkLibro = conexion.location();

            this.libro = new Libro(linkLibro, ScrappingUtils.convertirPrecio(precio), nombreTienda);
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo encontrar el libro en "+obtenerNombreTienda());
        }
    }
}
