package com.precioslibrosapi.Controller;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import com.precioslibrosapi.Scrapping.ScrapperFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @GetMapping("/{ISBN}")
    public @ResponseBody
    List<Libro> obtenerLibro(@PathVariable String ISBN) {
        return obtenerPrecios(ISBN);
    }

    private List<Libro> obtenerPrecios(String ISBN) {
        List<Libro> listaLibros = new ArrayList<>();
        List<Scrapper> scrappers = ScrapperFactory.obtenerScrappers();
        Map<Scrapper, Thread> hilos = new HashMap<>();

        for (Scrapper s : scrappers) {
            s.establecerISBN(ISBN);
            Thread hilo = new Thread(s);
            hilos.put(s, hilo);
            hilo.start();
        }

        Scrapper scrapper;

        for (int i = 0; i < hilos.size(); i++) {
            try {
                hilos.get(scrappers.get(i)).join();
                scrapper = scrappers.get(i);
                listaLibros.add(scrapper.obtenerLibro() != null ? scrapper.obtenerLibro() : new Libro("", "", scrapper.obtenerNombreTienda()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return listaLibros;
    }
}
