package net.ddns.dustriel.model.album;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.ddns.dustriel.model.SearchResult;

/**
 * The result of searching for a album album will fill in the details in this pojo. This class aims to hold basic album
 * data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumSearchResult extends SearchResult {

    private List<Artist> artists = new ArrayList<>();

    private String name;

    @JsonProperty("release_date")
    private String date;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return Objects.toString(
                "Album: { name: " + Objects.toString(name) + ", date: " + Objects.toString(date) + ", artists: "
                        + artists + " }");
    }
}
