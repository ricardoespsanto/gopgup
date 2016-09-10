package net.ddns.dustriel.engines.movie;

import java.util.List;

import net.ddns.dustriel.model.movie.MovieSearchResult;

/**
 * The contract to which 'movie' APIs have to adhere to be usable by our Gop Gup system.
 */
public interface MovieFinder {

    /**
     * Given any search string, it will look for movies and return a set of useful information regarding the results.
     *
     * @param movieSearch a simple string to use when searching for the movies
     * @return either an empty list of a list of @{@link MovieSearchResult} with details of the findings filled in
     */
    List<MovieSearchResult> listAllMatchesWithShortDetails(String movieSearch);

}
