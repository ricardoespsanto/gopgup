package net.ddns.dustriel.engines.implementations.movie.omdb;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import net.ddns.dustriel.engines.implementations.movie.omdb.model.MovieSearchResult;

/**
 * Test class for OMDBMovieFinder
 */
public class OMDBMovieFinderTest {

    @Test
    public void searchingForMoviesWillProduceAllAttributesFiledIn() {
        // The following cast is always allowed as we invoke directly the correct Finder
        @SuppressWarnings("unchecked")
        Collection<MovieSearchResult> movieSearchResults = (Collection<MovieSearchResult>) new OMDBMovieFinder()
                .listAllMatchesWithShortDetails("Indiana Jones");

        Assert.assertFalse(movieSearchResults.isEmpty());
        Assert.assertEquals(0, movieSearchResults.stream().filter(o -> o.getDirector().isEmpty()).count());
        Assert.assertEquals(0, movieSearchResults.stream().filter(o -> o.getDate().isEmpty()).count());
        Assert.assertEquals(0, movieSearchResults.stream().filter(o -> o.getTitle().isEmpty()).count());
    }

}