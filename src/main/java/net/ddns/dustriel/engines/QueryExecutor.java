package net.ddns.dustriel.engines;

import java.util.Collection;

import net.ddns.dustriel.engines.implementations.album.spotify.SpotifyAlbumFinder;
import net.ddns.dustriel.engines.implementations.movie.omdb.OMDBMovieFinder;
import net.ddns.dustriel.model.APINotSupportedException;
import net.ddns.dustriel.model.SearchResult;

/**
 * Executes a query given arguments and returns the list of objects representing the answer to that query
 */
public class QueryExecutor {

    private QueryExecutor() {
        // Hiding the default constructor
    }

    public static Collection<? extends SearchResult> execute() {
        String api = System.getProperty("api");
        if ("spotify".equalsIgnoreCase(api)) {
            String albumTitle = System.getProperty("album");
            return new SpotifyAlbumFinder().listAllMatchesWithShortDetails(albumTitle);
        }

        if ("omdb".equalsIgnoreCase(api)) {
            String movieTitle = System.getProperty("movie");
            return new OMDBMovieFinder().listAllMatchesWithShortDetails(movieTitle);
        }

        throw new APINotSupportedException("The given API: " + api + " is not supported");
    }
}
