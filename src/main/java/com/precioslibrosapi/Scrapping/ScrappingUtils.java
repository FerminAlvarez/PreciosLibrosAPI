package com.precioslibrosapi.Scrapping;

public class ScrappingUtils {
    public static Integer convertirPrecio(String precio){
        String limpio = precio.replaceAll("[^\\d,]","");
        limpio = limpio.replaceAll(",",".");
        Double precioDouble = Double.parseDouble(limpio);
        return precioDouble.intValue();
    }
}
