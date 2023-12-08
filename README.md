# Consumo de la Api Unsplash usando Retrofit, ROOM, patrón MVVM e inyección de dependencia con Dagger Hilt
Mediante este ejemplo accederemos a la api de Unsplash, la particularidad de este endpoint es que la api_key esta al final de la misma url, para ello haremos uso los Interceptor para agregar dicha api_key. El resultado obtenido de la api será almacenado en ROOM.

## Requisitos

- Android Studio Giraffe | 2022.3.1 Patch 4 o superior.
- Android Gradle Plugin Version 8.1.4
- Gradle Version 8.0
- Kotlin 1.9.10 o superior.

## Dependencias

- Retrofit: Para el consumo de la api.
- ViewModel y LiveData: Para la implementación del patrón MVVM.
- Dagger Hilt: Para la inyección de dependencias.
- Glide: Sera usado para cargar las imagenes.
- ROOM: Para almacenar la info recibida de la api.
- SplashScreeen: Para la implementación de la pantalla de carga.
- Material Design: Para la implementación de los componentes de diseño.
- Navigation: Para la implementación de la navegación entre pantallas.
- Coroutines: Para la implementación de hilos.


## Estructura del proyecto

- data: Contiene las clases, interfaces para el consumo de la api, manejo de room, implementacion del repositorio, etc.
- domain: Contiene el modelo, repositorio y el use case.
- ui: Contiene la interfaz de usuario, adaptador y el viewmodel.
- di: Contiene el modulo de inyección de dependencia.
- utils: Contiene las clases para el manejo de los estados de respuesta, mensajes, etc.

- 

## Resultado del endpoint
De todo el resultado obtenido del endpoint, estos serán los campos que manejaremos.

![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/respuesta_json.png)

## Estructura de la app
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/estructura_app.png)

## Imagen de la app

### Home
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/home.jpg)

### Registrar una nueva cuenta
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/api_cuenta.png)

### Datos de la api
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/pantalla_01.png)

### Info de la app
![Image text](https://github.com/programadorescs/ApiRestUnsplash/blob/master/app/src/main/assets/api_info.png)
