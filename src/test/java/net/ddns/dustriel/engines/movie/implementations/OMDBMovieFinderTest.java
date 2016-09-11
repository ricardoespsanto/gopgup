package net.ddns.dustriel.engines.movie.implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ddns.dustriel.model.movie.MovieSearchResult;

/**
 * Test class for OMDBMovieFinder
 */
public class OMDBMovieFinderTest {

    @Test
    public void listAllMatchesWithShortDetails() throws Exception {
        List<MovieSearchResult> movieSearchResults = new OMDBMovieFinder()
                .listAllMatchesWithShortDetails("Indiana Jones").getListOfSearchResults();

        Assert.assertFalse(movieSearchResults.isEmpty());

        Assert.assertTrue(movieSearchResults.get(0).getDirector().equalsIgnoreCase("Steven Spielberg"));
    }

}