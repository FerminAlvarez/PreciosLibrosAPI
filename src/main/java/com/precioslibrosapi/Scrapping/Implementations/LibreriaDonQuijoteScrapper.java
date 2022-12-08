package com.precioslibrosapi.Scrapping.Implementations;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import com.precioslibrosapi.Scrapping.ScrappingUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    public void scrappearLibro() {
        try {
            Document conexion = Jsoup.connect("https://www.libreriadonquijote.com.ar/search/?q=" + ISBN).get();
            Element portada = conexion.getElementsByClass("item-product").first();

            String titulo = portada.selectFirst("a").attr("title");
            String linkLibro = portada.selectFirst("a").attr("href");
            String precio = portada.getElementsByClass("item-price").first().text();
            String imagen = conexion.getElementsByClass("item-image").first().selectFirst("img").attr("data-srcset");
            String linkImagen = "http:" + imagen.split("320w, ")[1].split("480w")[0];

            this.libro = new Libro(titulo, linkLibro, ScrappingUtils.convertirPrecio(precio), nombreTienda, linkImagen);
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo encontrar el libro en "+obtenerNombreTienda());
        }
    }
}
