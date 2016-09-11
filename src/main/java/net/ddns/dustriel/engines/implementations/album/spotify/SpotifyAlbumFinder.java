package net.ddns.dustriel.engines.implementations.album.spotify;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.Finder;
import net.ddns.dustriel.engines.implementations.album.spotify.model.AlbumSearchResult;
import net.ddns.dustriel.engines.implementations.album.spotify.model.ListOfAlbumSearchResults;
import net.ddns.dustriel.model.InvalidSearchResultException;
import net.ddns.dustriel.model.SearchResult;

/**
 */
public class SpotifyAlbumFinder implements Finder {

    public SpotifyAlbumFinder() {
        super();
        setUpTheMapperToOurResponseType();
    }

    @Override
    public Collection<? extends SearchResult> listAllMatchesWithShortDetails(String albumTitle) {
        ListOfAlbumSearchResults albumsWithTitle = getAlbumsWithTitle(albumTitle)
                .orElseThrow(() -> new InvalidSearchResultException("Failed to perform an album search by title"));
        List<AlbumSearchResult> albumSearchResultList = albumsWithTitle.getAlbumItems().getAlbumList();
        for (int i = 0; i < albumSearchResultList.size(); i++) {
            AlbumSearchResult albumById = getAlbumById(albumSearchResultList.get(i).getId())
                    .orElseThrow(() -> new InvalidSearchResultException("Failed to perform an album search by id"));
            albumSearchResultList.set(i, albumById);
        }
        return albumsWithTitle.getAlbumItems().getAlbumList();
    }

    private Optional<AlbumSearchResult> getAlbumById(String albumId) {
        Optional<AlbumSearchResult> optionalAlbumSearchResult = Optional.empty();
        try {
            optionalAlbumSearchResult = Optional.ofNullable(
                    Unirest.get("https://api.spotify.com/v1/albums/{albumId}").routeParam("albumId", albumId)
                            .asObject(AlbumSearchResult.class).getBody());
        } catch (UnirestException e) {
            System.err.println("Unable to retrieve an album by its id: " + albumId + e.getMessage());
        }
        return optionalAlbumSearchResult;
    }

    private Optional<ListOfAlbumSearchResults> getAlbumsWithTitle(String albumTitle) {
        Optional<ListOfAlbumSearchResults> optionalListOfAlbumSearchResults = Optional.empty();
        try {
            optionalListOfAlbumSearchResults = Optional
                    .of(Unirest.get("https://api.spotify.com/v1/search").queryString("type", "album")
                            .queryString("q", albumTitle).asObject(ListOfAlbumSearchResults.class).getBody());
        } catch (UnirestException e) {
            System.err.println("Unable to search for albums with the given title: " + albumTitle + e.getMessage());
        }

        return optionalListOfAlbumSearchResults;
    }
}
