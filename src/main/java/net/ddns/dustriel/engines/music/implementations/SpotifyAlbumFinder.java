package net.ddns.dustriel.engines.music.implementations;

import java.util.List;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.music.AlbumFinder;
import net.ddns.dustriel.model.album.AlbumSearchResult;
import net.ddns.dustriel.model.album.ListOfAlbumSearchResults;

/**
 */
public class SpotifyAlbumFinder implements AlbumFinder {

    public SpotifyAlbumFinder() {
        super();
        setUpTheMapperToOurResponseType();
    }

    @Override
    public List<AlbumSearchResult> listAllMatchesWithShortDetails(String albumTitle) {
        ListOfAlbumSearchResults albumsWithTitle = getAlbumsWithTitle(albumTitle);
        List<AlbumSearchResult> albumSearchResultList = albumsWithTitle.getAlbumItems().getAlbumList();
        for (int i = 0; i < albumSearchResultList.size(); i++) {
            AlbumSearchResult albumById = getAlbumById(albumSearchResultList.get(i).getId());
            albumSearchResultList.set(i, albumById);
        }
        return albumSearchResultList;
    }

    private AlbumSearchResult getAlbumById(String albumId) {
        try {
            return Unirest.get("https://api.spotify.com/v1/albums/{albumId}").routeParam("albumId", albumId)
                    .asObject(AlbumSearchResult.class).getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ListOfAlbumSearchResults getAlbumsWithTitle(String albumTitle) {
        try {
            return Unirest.get("https://api.spotify.com/v1/search").queryString("type", "album")
                    .queryString("q", albumTitle).asObject(ListOfAlbumSearchResults.class).getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }
}
