package net.ddns.dustriel.model.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfAlbumSearchResults {

    @JsonProperty("albums")
    private AlbumItems albumItems;

    public AlbumItems getAlbumItems() {
        return albumItems;
    }

    public void setAlbumItems(AlbumItems albumItems) {
        this.albumItems = albumItems;
    }
}
