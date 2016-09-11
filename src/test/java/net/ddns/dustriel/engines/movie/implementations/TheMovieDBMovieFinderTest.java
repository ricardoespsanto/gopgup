package net.ddns.dustriel.engines.movie.implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ddns.dustriel.model.movie.MovieSearchResult;

/**
 * Testing the simple implementation of themoviedb
 */
public class TheMovieDBMovieFinderTest {

    @Test
    public void listAllMatchesWithShortDetails() throws Exception {
        List<MovieSearchResult> movieSearchResults = new TheMovieDBMovieFinder()
                .listAllMatchesWithShortDetails("Indiana Jones").getListOfSearchResults();

        Assert.assertFalse(movieSearchResults.isEmpty());

        Assert.assertTrue(movieSearchResults.get(0).getDirector().equalsIgnoreCase("Steven Spielberg"));
    }

}