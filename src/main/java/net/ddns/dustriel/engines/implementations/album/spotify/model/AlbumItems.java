package net.ddns.dustriel.engines.implementations.album.spotify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple wrapper to map the data received from this particular implementation
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumItems {

    @JsonProperty("items")
    private List<AlbumSearchResult> albumList;

    public List<AlbumSearchResult> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<AlbumSearchResult> albumList) {
        this.albumList = albumList;
    }
}
