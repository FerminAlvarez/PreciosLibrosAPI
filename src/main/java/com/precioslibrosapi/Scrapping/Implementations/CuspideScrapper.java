package com.precioslibrosapi.Scrapping.Implementations;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import com.precioslibrosapi.Scrapping.ScrappingUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class CuspideScrapper implements Scrapper {

    private final String nombreTienda = "Cuspide";
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
            Document conexion = Jsoup.connect("https://www.cuspide.com/resultados.aspx?c=" + ISBN + "&por=pal&orden=re").get();
            Element portada = conexion.getElementsByClass("libro libro").first();
            Element linkContainer = portada.selectFirst("a");

            String linkLibro = "https://www.cuspide.com" + linkContainer.attr("href");
            String precio = portada.getElementsByClass("precio").first().text();

            this.libro = new Libro(linkLibro, ScrappingUtils.convertirPrecio(precio), nombreTienda);
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo encontrar el libro en "+obtenerNombreTienda());
        }
    }
}
