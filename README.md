# Consumo de la Api Rick and Morty usando Clean Architecture, MVVM, Retrofit, Hilt, Room, Coroutines, Navigation, Material Design, Glide, etc.
Mediante esta app se consumira la api de Rick and Morty, se mostrara la lista de personajes, se podra agregar a favoritos y se podra ver los personajes agregados a favoritos.
## Requisitos

- Android Studio Jirafa| 2023.3.1 Patch 3
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


## Resultado del endpoint
De todo el resultado obtenido del endpoint, estos serán los campos que manejaremos.

![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/endpoint.png)

## Demostración de la app
![Video text](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExczVyczJueDluN3RqbjEwMzV4ODVwN2YzdjJxMHEzbXE0OGp2MGdlYiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/24LLj67VkfZr8H1mwe/giphy.gif)

## Estructura de la app
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/structureProject.png)

## Imagen de la app

### Splash Screen
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/splashScreen.jpg)

### Home
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/home.jpg)

### Detail Screen

![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/detailapp.jpg)

### Favorite Screen
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/favoritescreen.jpg)

### Add Favorite Screen
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/addFavoriteCharacter.jpg)

### Remove Favorite Screen
![Image text](https://github.com/EliasMP07/rickandmorty-api-clean_architecture-mvvm-retrofit-hilt-room/blob/main/app/src/main/assets/removefavoriteCharacter.jpg)
