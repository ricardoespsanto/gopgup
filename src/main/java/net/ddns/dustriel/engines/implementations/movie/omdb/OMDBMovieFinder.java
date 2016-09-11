package net.ddns.dustriel.engines.implementations.movie.omdb;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.Finder;
import net.ddns.dustriel.engines.implementations.movie.omdb.model.ListOfMovieSearchResults;
import net.ddns.dustriel.engines.implementations.movie.omdb.model.MovieSearchResult;
import net.ddns.dustriel.model.InvalidSearchResultException;
import net.ddns.dustriel.model.SearchResult;

/**
 * An implementation of MovieFinder that adheres to the OMDB API
 */
public class OMDBMovieFinder implements Finder {

    private static final String BASE_URL = "http://www.omdbapi.com/";

    public OMDBMovieFinder() {
        super();
        setUpTheMapperToOurResponseType();
    }

    @Override
    public Collection<? extends SearchResult> listAllMatchesWithShortDetails(String movieTitle) {
        ListOfMovieSearchResults listOfMovieSearchResults = searchMoviesByTitle(movieTitle).orElseThrow(
                () -> new InvalidSearchResultException("Invalid search results when searching movies by title"));
        List<MovieSearchResult> listOfSearchResults = listOfMovieSearchResults.getListOfSearchResults();
        for (int i = 0; i < listOfSearchResults.size(); i++) {
            MovieSearchResult movieSearchResult = listOfSearchResults.get(i);
            MovieSearchResult movieSearchResultWithDirector = searchMoviesByImdb(movieSearchResult.getImdbID())
                    .orElseThrow(() -> new InvalidSearchResultException(
                            "Invalid search results when searching movies by id"));
            movieSearchResult.setDirector(movieSearchResultWithDirector.getDirector());
            listOfSearchResults.set(i, movieSearchResult);
        }

        return listOfMovieSearchResults.getListOfSearchResults();
    }

    private Optional<MovieSearchResult> searchMoviesByImdb(String imdbID) {
        Optional<MovieSearchResult> optionalMovieSearchResul = Optional.empty();
        try {
            optionalMovieSearchResul = Optional.ofNullable(
                    Unirest.get(BASE_URL).queryString("i", imdbID).asObject(MovieSearchResult.class).getBody());
        } catch (UnirestException e) {
            System.err.println("Unable to search a movie by its imdb id " + e.getMessage());
        }
        return optionalMovieSearchResul;
    }

    private Optional<ListOfMovieSearchResults> searchMoviesByTitle(String movieTitle) {
        Optional<ListOfMovieSearchResults> optionalListOfMovieSearchResults = Optional.empty();
        try {
            optionalListOfMovieSearchResults = Optional.ofNullable(
                    Unirest.get("http://www.omdbapi.com/").queryString("s", movieTitle).queryString("type", "movie")
                            .asObject(ListOfMovieSearchResults.class).getBody());
        } catch (UnirestException e) {
            System.err.println("Unable to search a movie with the given title " + e.getMessage());
        }
        return optionalListOfMovieSearchResults;
    }
}
