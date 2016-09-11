package net.ddns.dustriel.engines.music.implementations;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import net.ddns.dustriel.model.album.AlbumSearchResult;

/**
 * Testing the spotify implementations
 */
public class SpotifyAlbumFinderTest {

    @Test
    public void listAllMatchesWithShortDetails() {
        List<AlbumSearchResult> albumSearchResults = new SpotifyAlbumFinder()
                .listAllMatchesWithShortDetails("Dirty Boots");

        Assert.assertFalse(albumSearchResults.isEmpty());

        Assert.assertEquals("Sid Vicious", albumSearchResults.get(0).getArtists().get(0));
    }

}