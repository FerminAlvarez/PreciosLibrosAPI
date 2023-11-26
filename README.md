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

Otra opción es montando tu propia imagen Docker
```shell
./mvnw install   
docker build -t ferminalvarezdev/precioslibrosapiscrapper .
docker tag precioslibrosapiscrapper ferminalvarezdev/precioslibrosapiscrapper
```
O utilizando la imagen pública
```shell
docker pull ferminalvarezdev/precioslibrosapiscrapper:latest
docker run -p 8080:8080 ferminalvarezdev/precioslibrosapiscrapper
```

## Obtención de precios

### Request
#### Endpoints

`GET http://localhost:8080/libreriadonquijote/<ISBN>/`

`GET http://localhost:8080/cuspide/<ISBN>/`

`GET http://localhost:8080/tematika/<ISBN>/`

`GET http://localhost:8080/buscalibre/<ISBN>/`

#### Ejemplo

`GET http://localhost:8080/buscalibre/9789876094887/`
   
### Response

```json
{
  "titulo" : "Secretos Familiares (Spanish Edition)",
  "link" : "https://www.buscalibre.com.ar/libro-secretos-familiares-spanish-edition/9789876094887/p/46864022",
  "precio" : 3420,
  "libreria" : "BuscaLibre",
  "link_imagen" : "https://images.cdn2.buscalibre.com/fit-in/360x360/c3/7b/c37b396e223c79991334515c594654a6.jpg"
}
```

### Demo
`GET https://precioslibrosapi-production.up.railway.app/libreriadonquijote/<ISBN>/`

`GET https://precioslibrosapi-production.up.railway.app/cuspide/<ISBN>/`

`GET https://precioslibrosapi-production.up.railway.app/tematika/<ISBN>/`

`GET https://precioslibrosapi-production.up.railway.app/buscalibre/<ISBN>/`

#### Ejemplo
`GET https://precioslibrosapi-production.up.railway.app/buscalibre/9788466658843/`
