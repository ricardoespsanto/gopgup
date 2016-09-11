package net.ddns.dustriel.engines.implementations.movie.omdb.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A wrapper around the result given by the api
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfMovieSearchResults {

    @JsonProperty("Search")
    private List<MovieSearchResult> listOfResults = new ArrayList<>();

    public void setListOfResults(List<MovieSearchResult> movieSearchResultList) {
        this.listOfResults = movieSearchResultList;
    }

    public List<MovieSearchResult> getListOfSearchResults() {
        return listOfResults;
    }
}
