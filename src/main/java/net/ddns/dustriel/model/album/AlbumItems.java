package net.ddns.dustriel.model.album;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
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
