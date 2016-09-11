package net.ddns.dustriel.engines.implementations.album.spotify;

import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;
import net.ddns.dustriel.engines.implementations.album.spotify.model.AlbumSearchResult;

/**
 * Testing the spotify implementations
 */
public class SpotifyAlbumFinderTest {

    @Test
    public void searchingForAlbumsWillProduceAllAttributesFiledIn() {
        // The following cast is always allowed as we invoke directly the correct Finder
        @SuppressWarnings("unchecked")
        Collection<AlbumSearchResult> albumSearchResults = (Collection<AlbumSearchResult>) new SpotifyAlbumFinder()
                .listAllMatchesWithShortDetails("Dirty Boots");

        Assert.assertFalse(albumSearchResults.isEmpty());

        org.junit.Assert.assertEquals(0, albumSearchResults.stream().filter(o -> o.getArtists().isEmpty()).count());
        // There must be at least one artist name
        org.junit.Assert.assertEquals(0, albumSearchResults.stream().filter(o -> o.getArtists().get(0).getName().isEmpty()).count());
        org.junit.Assert.assertEquals(0, albumSearchResults.stream().filter(o -> o.getDate().isEmpty()).count());
        org.junit.Assert.assertEquals(0, albumSearchResults.stream().filter(o -> o.getName().isEmpty()).count());
    }

}