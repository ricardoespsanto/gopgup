package net.ddns.dustriel.model.movie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.ddns.dustriel.model.ListOfSearchResults;

/**
 * A wrapper around the result given by the api
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfMovieSearchResults implements ListOfSearchResults {

    @JsonProperty("Search")
    private List<MovieSearchResult> listOfMovieSearchResults;

    public void setListOfMovieSearchResults(List<MovieSearchResult> movieSearchResultList) {
        this.listOfMovieSearchResults = movieSearchResultList;
    }

    @Override
    public List<MovieSearchResult> getListOfSearchResults() {
        return listOfMovieSearchResults;
    }
}
