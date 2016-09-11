package net.ddns.dustriel.engines.implementations.movie.omdb.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.ddns.dustriel.model.SearchResult;

/**
 * The result of searching for a movie will fill in the details in this pojo. This class aims to hold basic movie
 * details that have been curated to focus only on the most interesting and common references for a movie.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResult extends SearchResult {

    @JsonProperty("Director")
    private String director;

    private String imdbID;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String date;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return Objects.toString("Movie: { Title: " + title + ", year: " + date + ", Director: " + director + "}");
    }
}