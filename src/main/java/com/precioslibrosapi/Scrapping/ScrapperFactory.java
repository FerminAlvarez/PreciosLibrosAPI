package com.precioslibrosapi.Scrapping;

import com.precioslibrosapi.Scrapping.Implementations.BuscaLibreScrapper;
import com.precioslibrosapi.Scrapping.Implementations.CuspideScrapper;
import com.precioslibrosapi.Scrapping.Implementations.LibreriaDonQuijoteScrapper;
import com.precioslibrosapi.Scrapping.Implementations.TematikaScrapper;

import java.util.ArrayList;
import java.util.List;

public class ScrapperFactory {

    public static List<Scrapper> obtenerScrappers() {
        List<Scrapper> lista = new ArrayList<>();
        lista.add(new TematikaScrapper());
        lista.add(new BuscaLibreScrapper());
        lista.add(new CuspideScrapper());
        lista.add(new LibreriaDonQuijoteScrapper());
        return lista;
    }

    public static Scrapper obtenerLibreriaDonQuijoteScrapper(){
        return new LibreriaDonQuijoteScrapper();
    }

    public static Scrapper obtenerTematikaScrapper(){
        return new TematikaScrapper();
    }

    public static Scrapper obtenerBuscaLibreScrapper(){
        return new BuscaLibreScrapper();
    }

    public static Scrapper obtenerCuspideScrapper(){
        return new CuspideScrapper();
    }
}
