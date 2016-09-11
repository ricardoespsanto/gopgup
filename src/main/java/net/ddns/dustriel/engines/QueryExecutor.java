package net.ddns.dustriel.engines;

import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.movie.implementations.TheMovieDBMovieFinder;
import net.ddns.dustriel.interfaces.console.arguments.Arguments;
import net.ddns.dustriel.model.movie.ListOfMovieSearchResults;

/**
 * Executes a query given arguments and returns the list of objects representing the answer to that query
 */
public class QueryExecutor {

    public static ListOfMovieSearchResults execute(Arguments arguments) throws UnirestException {
        if (arguments.isAMusicAPI()) {
            return null;
        } else {
            return new TheMovieDBMovieFinder().listAllMatchesWithShortDetails(arguments.getMovie());
        }
    }
}
