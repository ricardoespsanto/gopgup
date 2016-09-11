package net.ddns.dustriel.engines.movie.implementations;

import java.util.List;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.movie.MovieFinder;
import net.ddns.dustriel.model.movie.ListOfMovieSearchResults;
import net.ddns.dustriel.model.movie.MovieSearchResult;

/**
 * An implementation of MovieFinder that adheres to the OMDB API
 */
public class OMDBMovieFinder implements MovieFinder {

    public OMDBMovieFinder() {
        super();
        setUpTheMapperToOurResponseType();
    }

    @Override
    public ListOfMovieSearchResults listAllMatchesWithShortDetails(String movieTitle) throws UnirestException {
        ListOfMovieSearchResults listOfMovieSearchResults = searchMoviesByTitle(movieTitle);
        List<MovieSearchResult> listOfSearchResults = listOfMovieSearchResults.getListOfSearchResults();
        for (int i = 0; i < listOfSearchResults.size(); i++) {
            MovieSearchResult movieSearchResult = listOfSearchResults.get(i);
            MovieSearchResult movieSearchResultWithDirector = searchMoviesByImdb(movieSearchResult.getImdbID());
            movieSearchResult.setDirector(movieSearchResultWithDirector.getDirector());
            listOfSearchResults.set(i, movieSearchResult);
        }
        return listOfMovieSearchResults;
    }

    private MovieSearchResult searchMoviesByImdb(String imdbID) {
        try {
            return Unirest.get("http://www.omdbapi.com/?i=" + imdbID).asObject(MovieSearchResult.class).getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ListOfMovieSearchResults searchMoviesByTitle(String movieTitle) {
        try {
            return Unirest.get("http://www.omdbapi.com/").queryString("s", movieTitle).queryString("type", "movie").asObject(ListOfMovieSearchResults.class).getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
