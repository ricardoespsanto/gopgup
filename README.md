**Gop Gup**

A system to search for albums and movies through public APIs

**Currently supporting the following APIs**
- http://www.omdbapi.com/ - Movies and related metadata
- https://developer.spotify.com/web-api/ - Album and related metadata

**Attributions & Credits**
This product uses the public APIs but it is not endorsed or certified by
neither of them.

**Run this application**
With two parameters: 
- api - with a value of omdb or spotify to query movies or albums 
        respectively
- movie - if omdb api was selected and ensure a movie title is given
- album - if spotify api was selected and ensure a album name is given

Example: java -Dapi=omdb -Dmovie="Indiana Jones" -jar gopGup-1.0-SNAPSHOT.jar
or 
java -Dapi=spotify -Dalbum=Nine -jar gopGup-1.0-SNAPSHOT.jar