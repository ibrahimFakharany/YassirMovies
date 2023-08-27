# YassirMovies

## Description

##### Android app for fetching the movies list from endpoint and Movie details for each movie, The app downloads the data first from the API and then saves it in the database lastly showing it to the user To ensure an excellent user experience and ensure working in weak internet conditions

##### For getting movies use endpoint https://api.themoviedb.org/3/discover/movie?api_key=[API_KEY]
##### For getting movie details use endpoint https://api.themoviedb.org/3/movie/{id}?api_key=[API_KEY]

## Screenshots

<img src="https://imgur.com/s9kdNOo.png" width="200">  <img src="https://imgur.com/I6pIFXd.png" width="200">

## Architecture
- Clean architecture
- MVI
- Multi-module
## Libraries 

- <b>Jetpack compose </b>-> for developing the app UI
- <b>ComposeDestination</b> -> for navigating between composables
- <b>Paging3</b> -> for paginated the data that is fetched from API and from the database
- <b>Room</b> -> for storing data locally 
- <b>Hilt</b> -> for dependency injection
- <b>Coroutines</b> -> asynchronous operations
- <b>KotlinFlow</b> -> for manipulating the streams of data
- <b>Retrofit</b> -> fetching the data from API
