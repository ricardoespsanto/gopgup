package net.ddns.dustriel.engines.movie.implementations;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.movie.MovieFinder;
import net.ddns.dustriel.model.movie.ListOfMovieSearchResults;

/**
 * An implementation of MovieFinder that adheres to the themoviedb API.
 * <p>
 * This implementation does not currently deliver all the details required. In particular it does not provide a director
 */
public class TheMovieDBMovieFinder implements MovieFinder {

    public TheMovieDBMovieFinder() {
        setUpTheMapperToOurResponseType();
    }

    @Override
    public ListOfMovieSearchResults listAllMatchesWithShortDetails(String movieSearch) throws UnirestException {
        String apiKey = "186886513b65fbc6de5687c2c2488fdb";
        String baseURL = "https://api.themoviedb.org/3/search/movie";
        return Unirest.get(baseURL).queryString("api_key", apiKey).queryString("query", movieSearch)
                .asObject(ListOfMovieSearchResults.class).getBody();
    }
}
