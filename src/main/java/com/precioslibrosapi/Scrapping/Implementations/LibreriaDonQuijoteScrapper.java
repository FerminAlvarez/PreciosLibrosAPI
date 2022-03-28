package com.precioslibrosapi.Scrapping.Implementations;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class LibreriaDonQuijoteScrapper implements Scrapper {

    private final String nombreTienda = "Libreria Don Quijote";
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

    private void scrappearLibro() {
        try {
            Document conexion = Jsoup.connect("https://www.libreriadonquijote.com.ar/search/?q=" + ISBN).get();
            Element portada = conexion.getElementsByClass("item-product").first();

            String precio = portada.getElementsByClass("item-price").first().text();
            String linkLibro = portada.selectFirst("a").attr("href");

            this.libro = new Libro(linkLibro, precio, nombreTienda);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        scrappearLibro();
    }
}