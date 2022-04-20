package com.precioslibrosapi.Controller;

import com.precioslibrosapi.Bean.Libro;
import com.precioslibrosapi.Scrapping.Scrapper;
import com.precioslibrosapi.Scrapping.ScrapperFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LibroController {

    @GetMapping("/libreriadonquijote/{ISBN}")
    public @ResponseBody
    Libro obtenerLibroLibreriaDonQuijote(@PathVariable String ISBN) {
        Scrapper scrapper = ScrapperFactory.obtenerLibreriaDonQuijoteScrapper();
        scrapper.establecerISBN(ISBN);
        scrapper.scrappearLibro();
        Libro libro = scrapper.obtenerLibro();
        if(libro != null){
            return libro;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping("/cuspide/{ISBN}")
    public @ResponseBody
    Libro obtenerLibroCuspide(@PathVariable String ISBN) {
        Scrapper scrapper = ScrapperFactory.obtenerCuspideScrapper();
        scrapper.establecerISBN(ISBN);
        scrapper.scrappearLibro();
        Libro libro = scrapper.obtenerLibro();
        if(libro != null){
            return libro;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping("/tematika/{ISBN}")
    public @ResponseBody
    Libro obtenerLibroTematika(@PathVariable String ISBN) {
        Scrapper scrapper = ScrapperFactory.obtenerTematikaScrapper();
        scrapper.establecerISBN(ISBN);
        scrapper.scrappearLibro();
        Libro libro = scrapper.obtenerLibro();
        if(libro != null){
            return libro;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping("/buscalibre/{ISBN}")
    public @ResponseBody
    Libro obtenerLibroBuscalibre(@PathVariable String ISBN) {
        Scrapper scrapper = ScrapperFactory.obtenerBuscaLibreScrapper();
        scrapper.establecerISBN(ISBN);
        scrapper.scrappearLibro();
        Libro libro = scrapper.obtenerLibro();
        if(libro != null){
            return libro;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }
}
