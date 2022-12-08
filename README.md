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
#### Endpoints

`GET http://localhost:8080/libreriadonquijote/<ISBN>/`

`GET http://localhost:8080/cuspide/<ISBN>/`

`GET http://localhost:8080/tematika/<ISBN>/`

`GET http://localhost:8080/buscalibre/<ISBN>/`

#### Ejemplo

`GET http://localhost:8080/libreriadonquijote/9789500209823/`
   
### Response

```json
{
  "link" : "https://www.libreriadonquijote.com.ar/productos/capitan-mediavista-en-la-bahia-de-los-cangrejos-muertos/",
  "precio" : 1590,
  "libreria" : "Libreria Don Quijote"
}
```

