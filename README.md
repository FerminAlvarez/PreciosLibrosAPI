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

`GET http://localhost:8080/libro/9789506445843/`
   
### Response

```json
[
    {
        "Link": "https://www.tematika.com/billy-summers-9789506445843.html",
        "Precio": "$3.599,00",
        "Librería": "Tematika"
    },
    {
        "Link": "https://www.buscalibre.com.ar/libro-billy-summers/9789506445843/p/53688790",
        "Precio": "$ 3.599",
        "Librería": "BuscaLibre"
    },
    {
        "Link": "https://www.cuspide.com/Libro/9789506445843/Billy+Summers",
        "Precio": "AR$ 3.599,00",
        "Librería": "Cuspide"
    },
    {
        "Link": "https://www.libreriadonquijote.com.ar/productos/billy-summers/",
        "Precio": "$3.599",
        "Librería": "Libreria Don Quijote"
    }
]
```

