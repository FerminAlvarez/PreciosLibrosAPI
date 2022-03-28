# PreciosLibrosAPI
Permite acceder a información como precio y link de un libro partiendo del ISBN realizando un scrapping de distintas librerías Argentinas.

## Requsitos
    • Java    
    • Maven

## Instalación
Pasos para la implementación

```shell
git clone https://github.com/FerminAlvarez/PreciosLibrosAPI.git
```
## Ejecución
La API estará corriendo en localhost.

```shell
cd PreciosLibrosAPI/
mvn spring-boot:run
```

## Obtención de precios

### Request

`GET http://localhost:8080/libro/<ISBN>/`

#### Ejemplo

`GET http://localhost:8080/libro/9789500209823/`
   
### Response

```json
[
    {
        "Link": "https://www.tematika.com/las-aventuras-de-sherlock-holmes-9789500209823.html",
        "Precio": 1220,
        "Librería": "Tematika"
    },
    {
        "Link": "https://www.buscalibre.com.ar/libro-una-aventura-literaria-con-antonio-pereira/9789500209823/p/50668519",
        "Precio": 1520,
        "Librería": "BuscaLibre"
    },
    {
        "Link": "https://www.cuspide.com/Libro/9789500209823/Las+Aventuras+De+Sherlock+Holmes",
        "Precio": 1520,
        "Librería": "Cuspide"
    },
    {
        "Link": "",
        "Precio": 0,
        "Librería": "Libreria Don Quijote"
    }
]
```

